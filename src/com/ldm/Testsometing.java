package com.ldm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Testsometing {

	// 生成文件路径
	static void verifyDir(String dirPath) {
		try {
			File f = new File(dirPath);// 获得文件对象
			if (!f.exists())// 如果路径不存在,则创建
				f.mkdirs();
		} catch (Exception e) {
		}
	}

	static void testZip(String test) {
		try {
			ZipFile zip = new ZipFile(test, Charset.forName("GBK"));
			for (Enumeration entries = zip.entries(); entries.hasMoreElements();) {
				ZipEntry ze = (ZipEntry) entries.nextElement();
				if (ze.isDirectory())
					continue;
				System.out.println(ze.getName());
			}
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

	static void delFile(String dir) {
		File file = new File(dir);
		if (!file.exists())
			System.out.println("文件不存在!!!");
		file.delete();
	}

	void saveTestCode() {
		// System.out.println("".equals(null));
		// System.out.println("2".getBytes());
		// System.out.println(Byte.parseByte(""));
		// verifyDir("D:/java_tools/server/apache-tomcat-7.0.62-windows-x64/apache-tomcat-7.0.62/webapps/files/20150908");
		// List<String[]> list = new ArrayList<String[]>();
		// String[] a = new String[2];
		// a[0]="哈哈 ";
		// a[1]="嘿嘿 ";
		// list.add(a);
		// for(String[] aaa:list){
		// System.out.println(aaa[0]);
		// System.out.println(aaa[1]);
		// }
		// System.out.println(System.getProperty("user.home"));
		// System.out.println(System.getProperty("java.io.tmpdir"));
		// System.out.println(true&&false);
		// testZip("C:\\Users\\Administrator\\Desktop\\2222222222.zip");
		// delFile("C:\\Users\\Administrator\\Desktop\\logo - 副本.jpg");
		// try {
		// ZipFile zf =new ZipFile("C:/Users/Administrator/Desktop/1.zip");
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// System.out.println("".equals("".trim()));

		// Byte.parseByte(null);
		// System.out.println("aaa".equals(null));
		if (!("aaa.jsp".endsWith(".jpg") || "aaa.jsp".endsWith(".jpeg"))) {
			System.out.println("111111111");
		} else {
			System.out.println("22222222");
		}
	}

	static void test1(String str) {
		switch (str) {
		case "李东明":
			System.out.println("好帅啊！！！");
			break;
		case "高克孟":
			System.out.println("好丑啊！！！");
			break;
		default:
			System.out.println("换一个,这名不识别！");
		}
	}

	void testThread() {
		TestThread tt1 = new TestThread("张三");
		TestThread tt2 = new TestThread("李四");
		Thread a = new Thread(tt1);
		Thread b = new Thread(tt2);
		a.start();
		long s = System.currentTimeMillis();
		for (int i = 0; i < 555555555; i++)
			;
		long e = System.currentTimeMillis();
		b.start();
		System.out.println("间隔用时：" + (e - s) + "微秒");
	}

	static void testSubString(String str, int begin, int end) {
		System.out.println(str.substring(begin, end));
	}

	// 九九乘法表
	void a9_9() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + "=" + j * i + (j * i < 10 ? "  " : " "));
			}
			System.out.println();
		}
	}

	// subString 前包后不包（前一个数字代表的索引,包含在sub之后的字符串里;后一个数字代表的索引,不包含在sub之后的字符串里）
	void testSubString() {
		testSubString("abcdefg", 2, 5);
		System.out.println("abceace".indexOf("e"));
	}

	private static int[] ai = new int[18];
	final static int[] wi = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 };
	final static int[] vi = { 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 };

	// 验证18位校验码,校验码采用ISO 7064：1983,MOD 11-2 校验码系统
	public static boolean verifyMOD(String code) {
		String verify = code.substring(17, 18);
		if ("x".equals(verify)) {
			code = code.replaceAll("x", "X");
			verify = "X";
		}
		String verifyIndex = getVerify(code);
		System.out.println("合法的最后一位是：" + verifyIndex);
		if (verify.equals(verifyIndex)) {
			return true;
		}
		// int x=17;
		// if(code.length()==15){
		// x=14;
		// }
		// System.out.println("错误：输入的身份证号最末尾的数字验证码错误");
		return false;
	}

	public static String getVerify(String eightcardid) {
		int remaining = 0;

		if (eightcardid.length() == 18) {
			eightcardid = eightcardid.substring(0, 17);
		}

		if (eightcardid.length() == 17) {
			int sum = 0;
			for (int i = 0; i < 17; i++) {
				String k = eightcardid.substring(i, i + 1);
				ai[i] = Integer.parseInt(k);
			}

			for (int i = 0; i < 17; i++) {
				sum = sum + wi[i] * ai[i];
			}
			remaining = sum % 11;
		}

		return remaining == 2 ? "X" : String.valueOf(vi[remaining]);
	}

	public void reflectTest() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		Method[] methods = this.getClass().getDeclaredMethods();
		for (Method temp : methods) {
			// System.out.println(temp.getName());
		}
		Testsometing ts = new Testsometing();
		Method me = this.getClass().getDeclaredMethod("testSubString");
		me.invoke(ts, null);
	}

	public static List<String> resolveTaxData(String data) {
		if (null != data && data.trim().length() > 0) {

		}

		return null;
	}

	public static String random() {
		StringBuilder code = new StringBuilder();
		Random random = new Random();
		// 6位验证码
		for (int i = 0; i < 6; i++) {
			code.append(String.valueOf(random.nextInt(10)));
		}
		return code.toString();
	}

	//JAVA原生API发送http请求-GET
	public static void sentHttpResquest() throws Exception {
		URL localurl = new URL("http://www.baidu.com");

		URLConnection uc = localurl.openConnection();

		HttpURLConnection httpUrlConnection = (HttpURLConnection) uc;
		httpUrlConnection.setRequestProperty("accept-Charset", "utf-8");
		httpUrlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader bufferReader = null;
		String tempLine = null;
		StringBuffer stringBuffer = new StringBuffer();
		if (httpUrlConnection.getResponseCode() >= 300) {
			throw new Exception("http Resqust not successed");
		}
		try {
			inputStream = httpUrlConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream);
			bufferReader = new BufferedReader(inputStreamReader);
			while ((tempLine = bufferReader.readLine()) != null) {
				stringBuffer.append(tempLine + "\r\n");
			}
		} finally {
			inputStream.close();
			inputStreamReader.close();
			bufferReader.close();
		}
		System.out.println(stringBuffer.toString());
	}
	//JAVA原生API发送http请求-POST
	public static String sentHttpPostResquest() throws Exception {
        String parameterData = "username=nickhuang&blog=http://www.cnblogs.com/nick-huang/";
        
        URL localURL = new URL("http://localhost:8080/OneHttpServer/");
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;
        
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Accept-Charset", "utf-8");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterData.length()));
        
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        
        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            
            outputStreamWriter.write(parameterData.toString());
            outputStreamWriter.flush();
            
            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }
            
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);
            
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
            
        } finally {
            
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            
            if (outputStream != null) {
                outputStream.close();
            }
            
            if (reader != null) {
                reader.close();
            }
            
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            
            if (inputStream != null) {
                inputStream.close();
            }
            
        }

        return resultBuffer.toString();
    }
	
	/**
	  * @author Administrator
	  * @Description: 测试"/"和"\"构成的文件路径，在IO操作中是否有区别
	  * @param   
	  * @return void  
	  * @throws
	  * @date 2016年1月22日 上午10:23:17
	  */
	public static void testIO(){
		
		String path = "C:\\Users\\Administrator\\Desktop\\111";
		String path1=path.replaceAll("\\\\", "/");
		System.out.println("path:"+path);
		System.out.println("path1:"+path1);
		File file = new File(path);
		File file1 = new File(path1,"1.jpg");
		System.out.println("filePath:"+file.getAbsolutePath());
		System.out.println("file1Path:"+file1.getAbsolutePath());
		System.out.println("path:"+file.isDirectory());
		System.out.println("path:"+file.isFile());
		System.out.println("path1:"+file1.isDirectory());
		System.out.println("path1:"+file1.isFile());
		FileInputStream input = null;
		FileOutputStream out = null;
		try {
			input = new FileInputStream(file1);
		
			out = new FileOutputStream(new File("C:/Users/Administrator/Desktop/111","temp.jpg"));
			int temp;
			byte[] length = new byte[1024];
			while((temp=input.read(length))!=-1){
				out.write(length, 0, temp);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}finally {
			if(input != null){
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(out != null){
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		//获取文件夹下的文件
		System.out.println(file.listFiles().length);
		//新建file，不带路径直接用文件名创建file，创建的file路径为项目根路径，运行如下代码，结果：E:\workspace\ldm\a.jpg
		File fileaa = new File("a.jpg");
		System.out.println(fileaa.getAbsolutePath());
	}
	
	
	/**
	  * @author Administrator
	  * @Description: 数组、各种集合间相互转换、排序
	  * @param   
	  * @return void  
	  * @throws
	  * @date 2016年2月18日 上午10:40:42
	  */
	private static void testSort(){
		List<String> list = new ArrayList<>();
		list.add("aa");
		list.add("aa");
		list.add(77+"");
		list.add(77+"");
		list.add(99+"");
		list.add("bb");
		list.add(11+"");
		list.add(88+"");
		//list去重及排序 使用TreeSet
		Set<String> set = new TreeSet<>(list);
		System.out.println(list);
		System.out.println(set);
		
		
		String[] arr = new String[]{"222","333","111"};
		//数组转换为List
		List<String> list1 = new ArrayList<>(Arrays.asList(arr));
		System.out.println(list1);
		
		
		//数组排序使用Arrays.sort()
		Arrays.sort(arr);
		for(String tem:arr){
			System.out.println(tem);
		}
	}
	

	public static void main(String[] args) throws Exception {
	}

}
