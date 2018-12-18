package org.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.util.Base64Utils;

import com.mysql.jdbc.util.Base64Decoder;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64ToImageUtil {

	/**
	 * base64图片上传
	 * @param str
	 * @return
	 * @throws Exception
	 */
	public static String upload(String base64Data,String path,String dir)throws Exception{
		String dataPrix = "";
        String data = "";
        if(base64Data == null || "".equals(base64Data)){
            throw new Exception("上传失败，上传图片数据为空");
        }else{
            String [] d = base64Data.split("base64,");
            if(d != null && d.length == 2){
                dataPrix = d[0];
                data = d[1].replaceAll("\\ ", "+"); //看看有没有空格，有的就替换成+号，传送的时候+号被http协议去掉了
            }else{
                throw new Exception("上传失败，数据不合法");
            }
        }
        String suffix = "";
        if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
            suffix = ".jpg";
        } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
            suffix = ".ico";
        } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
            suffix = ".gif";
        } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        }else{
            throw new Exception("上传图片格式不合法");
        }
        String tempFileName = UUID.randomUUID().toString().replace("-", "") + suffix;
        path = path + "/uploadFolder/" + dir;
        File dirFile = new File(path);
    	if(!dirFile.exists() || !dirFile .isDirectory()){
    		dirFile.mkdirs();
    	}
        //因为BASE64Decoder的jar问题，此处使用spring框架提供的工具包
        byte[] bs = Base64.decodeBase64(data);//Base64Utils.decodeFromString(data);
        try{
            //使用apache提供的工具类操作流
            FileUtils.writeByteArrayToFile(new File(path, tempFileName), bs);  
        }catch(Exception ee){
            throw new Exception("上传失败，写入文件失败，"+ee.getMessage());
        }
        System.out.println(base64Data);
		return "/uploadFolder/"+dir+"/"+tempFileName;
	}
	
}
