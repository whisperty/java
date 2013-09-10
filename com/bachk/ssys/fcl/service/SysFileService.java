package com.bachk.ssys.fcl.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.bachk.ssys.fcl.model.SysFile;


@Service
public class SysFileService {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	public long save(String fileName, byte[] fileData, Date expiredDate) throws IOException{
		SysFile file = new SysFile();
		file.setFileName(fileName);
		file.setFileData(Hibernate.createBlob(fileData));
		file.setExpiredDate(expiredDate);
		file.setCreatedDate(new Date());
		return save(file);
	}
	
	public long save(String fileName, byte[] fileData) throws IOException{
		return save(fileName, fileData, null);
	}
	
	public long save(SysFile file){
		hibernateTemplate.saveOrUpdate(file);
		return file.getId();
	}
	
	public long save(byte[] fileData) throws IOException{
		return save(null, fileData, null);
	}
	
	
	public SysFile get(Long fileId) throws SQLException{
		SysFile file = hibernateTemplate.get(SysFile.class, fileId);
		return file;
	}
	
	public InputStream getInputStream(Long fileId) throws SQLException{
		SysFile file =  hibernateTemplate.get(SysFile.class, fileId);
		return file.getFileData().getBinaryStream();
	}
	
}