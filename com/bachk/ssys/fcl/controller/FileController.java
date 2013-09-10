package com.bachk.ssys.fcl.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bachk.ssys.fcl.model.SysFile;
import com.bachk.ssys.fcl.service.SysFileService;

@Controller
public class FileController {

	@Autowired
	SysFileService fileService;

	@RequestMapping(value = "upload")
	public void upload(@RequestParam("Filedata") MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String fileName = new String( file.getOriginalFilename().getBytes("iso8859-1"), "utf8" );
		Long fid = fileService.save(fileName, file.getBytes());
		response.getOutputStream().write(fid.toString().getBytes());
	}

	@RequestMapping(value = "download")
	public void download(@RequestParam("fid") Long fileId, HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {

		SysFile file = fileService.get(fileId);
		if (file == null) return;
		
		String fileName = file.getFileName();
		if (fileName == null) fileName = file.getId().toString();
		fileName = new String( fileName.getBytes("utf8"), "iso8859-1" );
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");

		ServletOutputStream out = response.getOutputStream();
		InputStream in = file.getFileData().getBinaryStream();

		byte[] outputByte = new byte[4096];
		int len = in.read(outputByte);
		while (len  != -1) {
			out.write(outputByte, 0, len);
			len = in.read(outputByte);
		}
		
		in.close();
		out.flush();
		out.close();
	}
}
