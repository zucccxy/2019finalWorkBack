package org.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class HtmlToWordUtil {
	
	public static final String ENGINE_DIR = "engine";
	
	/**
	 * 
	 * @param basePath 文件上传根目录
	 * @param engineId 工程id
	 * @param content 合同内容
	 * @param contractName 合同名称
	 * @param name 上传文件夹名称
	 * @return
	 * @throws Exception
	 */
	public static String toWord(String basePath,Long engineId, String content, String contractName, String name)throws Exception{
		//最终访问路径
		String accessPath = "";
		// /engine1/contract
		String path = "/" + ENGINE_DIR + engineId + "/" + name;
		String filePath = basePath + path;
		File dirFile = new File(filePath);
		//判断文件夹是否存在
		if(!dirFile.exists() || !dirFile .isDirectory()){
    		dirFile.mkdir();
    	}
		//重置文件名
    	Long nowTime = System.currentTimeMillis();
		String fileName = contractName + nowTime + ".doc";
		//写入word
		OutputStream os = null;
    	InputStream is = null;
    	is = new ByteArrayInputStream(content.getBytes("UTF-8"));
    	os = new FileOutputStream(dirFile + "/" +fileName);
    	translateFile(is,os);
    	//配置访问路径
    	accessPath = "upload"+ path + "/" + fileName;
		return accessPath;
	}
	
	/**
     * 把is写入到对应的word输出流os中
     * 不考虑异常的捕获，直接抛出
     * @param is
     * @param os
     * @throws IOException
     */
	public static void translateFile(InputStream is, OutputStream os) throws Exception{
		POIFSFileSystem fs = new POIFSFileSystem();
		try {
			fs.createDocument(is, "WordDocument");
			fs.writeFilesystem(os);
			os.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
