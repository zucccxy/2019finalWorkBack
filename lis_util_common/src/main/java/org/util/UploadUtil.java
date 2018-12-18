package org.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 * 上传图片工具类（需要根据上传的name创建一个文件夹来存放图片）
 * 
 * @author Administrator
 *
 */
public class UploadUtil {
//	/**
//	 * 上传并压缩
//	 * @param upPath
//	 * @param myfile
//	 * @return
//	 * @throws Exception
//	 *//*
//	public static String uploadDown(String upPath, MultipartFile myfile) throws Exception {
//		String imgPathurl = null;
//		if (myfile.isEmpty()) {
//			System.out.println("文件未上传");
//		} else {
//			System.out.println("文件长度: " + myfile.getSize());
//			System.out.println("文件类型: " + myfile.getContentType());
//			System.out.println("文件名称: " + myfile.getName());
//			System.out.println("文件原名: " + myfile.getOriginalFilename());
//			System.out.println("========================================");
//			// 使用自定义文件资源库
//			String filedirname = myfile.getName();
//			String realPath = upPath + "/" + filedirname;
//			try {
//				// 重置文件名
//				long time = System.currentTimeMillis();
//				String timeStr = String.valueOf(time);
//				String[] originalFileName = myfile.getOriginalFilename().split("\\.");
//				Integer length = originalFileName.length;
//				String type = originalFileName[length - 1];
//				String fileName = timeStr + "." + type;
//				FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, fileName));
//				// 配置图片访问路径
//				imgPathurl = filedirname + "/" + fileName;
//				if (null != imgPathurl) {
//					imgPathurl = downSize(imgPathurl, upPath, type);
//				}
//			} catch (IOException e) {
//				return null;
//			}
//		}
//		return imgPathurl;
//	}
//*/
//	/**
//	 * 传入文件名和真实路径，还有类型
//	 *
//	 * 压缩
//	 *
//	 * @param fileName
//	 * @param upPath
//	 * @param type
//	 * @return
//	 * @throws Exception
//	 *//*
//	public static String downSize(String fileName, String upPath, String type) throws Exception {
//		String myfileurl = fileName;
//		final String filedirname = "downsize";
//		File myfile = new File(upPath + "/" + filedirname);
//		if (!myfile.exists()) {
//			myfile.mkdirs();
//		}
//		if (null != fileName && null != upPath && null != type) {
//			File file = new File(upPath + "/" + fileName);
//			if (file.exists()) {
//				if (file.length() * 1.0 / 1024 / 1024 >= 0.3) {// 300k会进行压缩
//					String timeStr = String.valueOf(System.currentTimeMillis());
//					String filename = upPath + "/" + filedirname + "/" + timeStr + "." + type;
//
//					 * Thumbnails.of(file).scale(1f).outputQuality(0.25f).toFile(new
//					 * File(filename));
//					 * Thumbnails.of(file).size(640,
//					 * 640).outputQuality(0.25f).toFile(new File(filename));
//
//					Thumbnails.of(file).size(640, 640).toFile(new File(filename));
//					myfileurl = filedirname + "/" + timeStr + "." + type;
//					file.delete();
//				}
//			}
//		}
//		return myfileurl;
//	}*/
//	/**
//	 * 普通上传文件
//	 * @param upPath
//	 * @param myfile
//	 * @return
//	 * @throws Exception
//	 */
//	public static String uploadfile(String upPath, MultipartFile myfile) throws Exception {
//		String imgPathurl = null;
//		if (myfile.isEmpty()) {
//			System.out.println("文件未上传");
//		} else {
//			System.out.println("文件长度: " + myfile.getSize());
//			System.out.println("文件类型: " + myfile.getContentType());
//			System.out.println("文件名称: " + myfile.getName());
//			System.out.println("文件原名: " + myfile.getOriginalFilename());
//			System.out.println("========================================");
//			String filedirname = myfile.getName();
//			String realPath = upPath + "/" + filedirname;
//			try {
//				// 重置文件名
//				long time = System.currentTimeMillis();
//				String timeStr = String.valueOf(time);
//				String[] originalFileName = myfile.getOriginalFilename().split("\\.");
//				Integer length = originalFileName.length;
//				String type = originalFileName[length - 1];
//				String fileName = timeStr + "." + type;
//				FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(realPath, fileName));
//				// 配置图片访问路径
//				imgPathurl = filedirname + "/" + fileName;
//			} catch (IOException e) {
//				return null;
//			}
//		}
//
//		return imgPathurl;
//	}
//
//	private static byte[] decode(String content) {
//		return Base64.decodeBase64(content);
//	}
//
//	/**
//	 * base64上传图片工具类
//	 *
//	 * @param img
//	 * @param uploadPath
//	 * @param dir  对应文件夹
//	 * @return
//	 * @throws IOException
//	 */
//	public static String base64Upload(String img, String uploadPath) throws IOException {
//		//dir=dir==null?"uploadbase64":dir;
//		if (null!=uploadPath&&null != img && img.length() != 0 ) {
//			try {
//				String typename=img.substring(img.indexOf("/")+1,img.indexOf(";"));
//				String string = img.substring(img.indexOf(",") + 1);
//				byte[] data = decode(string);
//				String imageName = System.currentTimeMillis() + "."+typename;
//				String imagePathName = "/uploadFile/" + imageName;
//				File file = new File(uploadPath + "/uploadFile/");
//				// 如果文件夹不存在则创建
//				if (!file.exists() && !file.isDirectory()) {
//					file.mkdirs();
//				}
//				FileOutputStream outputStream = new FileOutputStream(new File(uploadPath + imagePathName));
//				outputStream.write(data);
//				outputStream.flush();
//				outputStream.close();
//				String path = "upload" + imagePathName;
//				return path;
//			}catch (Exception e) {
//				return null;
//			}
//		}
//		return null;
//	}
//	/**
//	 * 暂时无用
//	 * @param data
//	 * @param path
//	 */
//	@SuppressWarnings("unused")
//	private static void saveBinaryFile(byte[] data, String path) {
//		File file = new File(path);
//		try {
//			BufferedOutputStream bos = new BufferedOutputStream(
//					new FileOutputStream(file));
//			bos.write(data);
//			bos.flush();
//			bos.close();
//		} catch (IOException ioe) {
//		}
//	}
//
////	public static void main(String[] args) throws Exception {
////		System.out.println(base64Upload("base64字符串","F:/upload",null));
////	}
}
