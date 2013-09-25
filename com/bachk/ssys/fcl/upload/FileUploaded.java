package com.bachk.ssys.fcl.upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author lqw
 */
public class FileUploaded extends HttpServlet {

    // 定义文件的上传路径
    private String uploadPath = "G:\\workplace\\fcl\\src\\main\\webapp\\streamnetwork-debug\\uploadFiles\\";

    // 限制文件的上传大小
//    private int maxPostSize = 100 * 1024 * 1024;

    public FileUploaded() {
        super();
    }

    public void destroy() {
        super.destroy();
    }

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
       System.out.println("!");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 保存文件到服务器中

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(4096);
        ServletFileUpload upload = new ServletFileUpload(factory);
 //       upload.setSizeMax(maxPostSize);
        try {
            List fileItems = upload.parseRequest(request);
            Iterator iter = fileItems.iterator();
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                if (!item.isFormField()) {
                    String name = item.getName();
                    System.out.println(name);
                    try {
                        item.write(new File(uploadPath + name));
                        // SaveFile s = new SaveFile();
                        // s.saveFile(name);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
            System.out.println(e.getMessage() + "结束");
        }
    }

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    public String getServletInfo() {
        return "Short description";
    }

}