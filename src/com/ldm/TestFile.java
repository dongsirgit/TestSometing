package com.ldm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class TestFile implements Serializable {
	
	public void test1(){
	}
	
	public static void main(String[] args) {
		File file = new File("E:\\software\\new");
		if(!file.exists()) file.mkdirs();
		
		try {
			InputStream is = new FileInputStream("E:\\software\\Firefox_V40.0.0.5697_setup.1439347708.exe");
			OutputStream os = new FileOutputStream("E:\\software\\new\\Firefox_V40.0.0.5697_setup.1439347708.exe");
			byte[] buffer = new byte[1024];
			int len =0;
			while((len=is.read(buffer))!=-1){
				os.write(buffer, 0, len);
			}
			is.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}
	}

}
