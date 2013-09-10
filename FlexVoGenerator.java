import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.h2.command.dml.Set;
import org.w3c.dom.Document;

@SuppressWarnings("rawtypes")
public class FlexVoGenerator {
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		generate("com.bachk.ssys.fcl.model", "target/flexVo");

	}

	private static void generate(String packageName, String outFolder) throws ClassNotFoundException, IOException {
		List<Class> classes = getClasses(packageName);
		for (Class c : classes) {
			generate(c, classes, outFolder);
		}
	}

	private static void generate(Class javaClass, List<Class> classes, String outFolder) throws FileNotFoundException {

		List<String> imports = new LinkedList<String>();
		List<String> fields = new LinkedList<String>();

		ArrayList<Field> flds = new ArrayList<Field>();
		for (Class c = javaClass; !c.equals(Object.class); c = c.getSuperclass()){
			Field[] subFields = c.getDeclaredFields();
			for (Field field: subFields) flds.add(field);
		}
		
		for (Field field : flds) {
			Class type = field.getType();
			if (type.equals(String.class)) {
				fields.add("public var " + field.getName() + ":String;");
			} else if (type.equals(Boolean.class) || type.equals(boolean.class)) {
				fields.add("public var " + field.getName() + ":Boolean;");
			} else if (type.equals(Integer.class) || type.equals(int.class)) {
				fields.add("public var " + field.getName() + ":int;");
			} else if (type.equals(Short.class) || type.equals(short.class)) {
				fields.add("public var " + field.getName() + ":int;");
			} else if (type.equals(Byte.class)) {
				fields.add("public var " + field.getName() + ":int;");
			} else if (type.equals(Double.class) || type.equals(double.class)) {
				fields.add("public var " + field.getName() + ":Number;");
			} else if (type.equals(Long.class) || type.equals(long.class)) {
				fields.add("public var " + field.getName() + ":Number;");
			} else if (type.equals(Float.class) || type.equals(float.class)) {
				fields.add("public var " + field.getName() + ":Number;");
			} else if (type.equals(Character.class) || type.equals(char.class)) {
				fields.add("public var " + field.getName() + ":String;");
			} else if (type.equals(BigInteger.class)) {
				fields.add("public var " + field.getName() + ":String;");
			} else if (type.equals(BigDecimal.class)) {
				fields.add("public var " + field.getName() + ":String;");
			} else if (type.equals(Calendar.class)) {
				fields.add("public var " + field.getName() + ":Date;");
			} else if (type.equals(Date.class)) {
				fields.add("public var " + field.getName() + ":Date;");
			} else if (type.equals(Dictionary.class)) {
				fields.add("public var " + field.getName() + ":Object;");
			} else if (type.equals(Document.class)) {
				fields.add("public var " + field.getName() + ":XML;");
			} else if (type.isArray()) {
				Class componentType = type.getComponentType();
				if (componentType.equals(byte.class)) {
					fields.add("public var " + field.getName() + ":int;");
				} else if (componentType.equals(Byte.class)) {
					fields.add("public var " + field.getName() + ":ByteArray;");
					imports.add("import flash.utils.ByteArray;");
				} else if (componentType.equals(char.class) || componentType.equals(Character.class)) {
					fields.add("public var " + field.getName() + ":String;");
				} else if (componentType.equals(Object.class)) {
					fields.add("public var " + field.getName() + ":Array;");
				}
			} else {
				try {
					if (type.isInterface()) {
						if (type.equals(List.class) || type.equals(Set.class)) {
							fields.add("public var " + field.getName() + ":ArrayCollection;");
							imports.add("import mx.collections.ArrayCollection;");
						} else if (type.equals(Map.class)) {
							fields.add("public var " + field.getName() + ":Object;");
						}
					} else {

						Object object = type.newInstance();
						if (object instanceof Collection) {
							fields.add("public var " + field.getName() + ":ArrayCollection;");
							imports.add("import mx.collections.ArrayCollection;");
						} else if (object instanceof Map) {
							fields.add("public var " + field.getName() + ":Object;");
						} else {
							for (Class cla : classes) {
								if (type.equals(cla)) {
									fields.add("public var " + field.getName() + ":" + cla.getSimpleName() + ";");
									imports.add("import " + cla.getName() + ";");
									break;
								}
							}

						}
					}
				} catch (Exception e) {

				}
			}

		}

		File dir = new File(outFolder + "/" + javaClass.getPackage().getName().replace('.', '/'));
		if (!dir.exists())
			dir.mkdirs();
		PrintWriter pw = new PrintWriter(new File(dir.getAbsolutePath() + "/" + javaClass.getSimpleName() + ".as"));
		pw.println("package " + javaClass.getPackage().getName());
		pw.println("{");

		for (String ipt : imports) {
			pw.println(tab(1) + ipt);
		}
		pw.println();

		pw.println(tab(1) + "[Bindable]");
		pw.println(tab(1) + "[RemoteClass(alias=\"" + javaClass.getName() + "\")]");
		pw.println(tab(1) + "public class " + javaClass.getSimpleName());
		pw.println(tab(1) + "{");

		for (String field : fields) {
			pw.println(tab(2) + field);
		}
		pw.println(tab(1) + "}");
		pw.println();
		pw.println("}");
		pw.flush();
		pw.close();
	}

	private static String tab(int count) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < count; i++) {
			builder.append('\t');
		}
		return builder.toString();
	}

	private static List<Class> getClasses(String packageName) throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			String fileName = resource.getFile();
			String fileNameDecoded = URLDecoder.decode(fileName, "UTF-8");
			dirs.add(new File(fileNameDecoded));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes;
	}

	private static List<Class> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class> classes = new ArrayList<Class>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			String fileName = file.getName();
			if (file.isDirectory()) {
				assert !fileName.contains(".");
				classes.addAll(findClasses(file, packageName + "." + fileName));
			} else if (fileName.endsWith(".class") && !fileName.contains("$")) {
				Class _class;
				try {
					_class = Class.forName(packageName + '.' + fileName.substring(0, fileName.length() - 6));
				} catch (ExceptionInInitializerError e) {
					// happen, for example, in classes, which depend on
					// Spring to inject some beans, and which fail,
					// if dependency is not fulfilled
					_class = Class.forName(packageName + '.' + fileName.substring(0, fileName.length() - 6), false, Thread.currentThread()
							.getContextClassLoader());
				}
				classes.add(_class);
			}
		}
		return classes;
	}
	
}
