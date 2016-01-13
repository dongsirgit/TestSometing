package com.ldm;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class Testsomting {
	
	
	//生成文件路径
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
				ZipFile zip = new ZipFile(test,Charset.forName("GBK"));
				for (Enumeration entries = zip.entries(); entries.hasMoreElements();) {
					ZipEntry ze = (ZipEntry) entries.nextElement();
					if(ze.isDirectory()) continue;
					System.out.println(ze.getName());
				}
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		static void delFile(String dir){
			File file = new File(dir);
			if(!file.exists()) System.out.println("文件不存在!!!");
			file.delete();
		}
		
		void saveTestCode(){
//			System.out.println("".equals(null));
//			System.out.println("2".getBytes());
//			System.out.println(Byte.parseByte(""));
//			verifyDir("D:/java_tools/server/apache-tomcat-7.0.62-windows-x64/apache-tomcat-7.0.62/webapps/files/20150908");
//			List<String[]> list = new ArrayList<String[]>();
//			String[] a = new String[2];
//			a[0]="哈哈 ";
//			a[1]="嘿嘿 ";
//			list.add(a);
//			for(String[] aaa:list){
//				System.out.println(aaa[0]);
//				System.out.println(aaa[1]);
//			}
//			System.out.println(System.getProperty("user.home"));
//			System.out.println(System.getProperty("java.io.tmpdir"));
//			System.out.println(true&&false);
//			testZip("C:\\Users\\Administrator\\Desktop\\2222222222.zip");
//			delFile("C:\\Users\\Administrator\\Desktop\\logo - 副本.jpg");
//			try {
//				ZipFile zf =new ZipFile("C:/Users/Administrator/Desktop/1.zip");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//			System.out.println("".equals("".trim()));
			
//			Byte.parseByte(null);
//			System.out.println("aaa".equals(null));
			if(!("aaa.jsp".endsWith(".jpg") || "aaa.jsp".endsWith(".jpeg"))){
				System.out.println("111111111");
			}else{
				System.out.println("22222222");
			}
		}
		
		static void test1(String str){
			switch(str){
			case "李东明" :System.out.println("好帅啊！！！");break;
			case "高克孟" :System.out.println("好丑啊！！！");break;
			default:System.out.println("换一个,这名不识别！");
			}
		}
		
		void testThread(){
			TestThread tt1 = new TestThread("张三");
			TestThread tt2 = new TestThread("李四");
			Thread a = new Thread(tt1);
			Thread b = new Thread(tt2);
			a.start();
			long s = System.currentTimeMillis();
			for(int i=0;i<555555555;i++);
			long e = System.currentTimeMillis();
			b.start();
			System.out.println("间隔用时："+(e-s)+"微秒");
		}
		
		static void testSubString(String str,int begin,int end){
			System.out.println(str.substring(begin, end));
		}
		
		//九九乘法表
		void a9_9(){
			for(int i=1;i<10;i++){
				for(int j=1;j<=i;j++){
					System.out.print(j+"*"+i+"="+j*i+(j*i<10?"  ":" "));
				}
				System.out.println();
			}
		}
		
		//subString 前包后不包（前一个数字代表的索引,包含在sub之后的字符串里;后一个数字代表的索引,不包含在sub之后的字符串里）
		void testSubString(){
			testSubString("abcdefg", 2, 5);
			System.out.println("abceace".indexOf("e"));
		}
		
		
		private static int[] ai = new int[18];
		final static int[] wi = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
		final static int[] vi = {1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2};
		//验证18位校验码,校验码采用ISO 7064：1983,MOD 11-2 校验码系统
	      public static boolean verifyMOD(String code){
	            String verify = code.substring(17, 18);
	            if("x".equals(verify)){
	                  code=code.replaceAll("x","X");
	                  verify="X";
	            }
	            String verifyIndex=getVerify(code);
	            System.out.println("合法的最后一位是："+verifyIndex);
	            if (verify.equals(verifyIndex)) {
	                  return true;
	            }
//	            int x=17;
//	            if(code.length()==15){
//	                  x=14;
//	            }
//	            System.out.println("错误：输入的身份证号最末尾的数字验证码错误");
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
		
		public void reflectTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
			
			Method[] methods = this.getClass().getDeclaredMethods();
			for(Method temp:methods){
//				System.out.println(temp.getName());
			}
			Testsomting ts = new Testsomting();
			Method me = this.getClass().getDeclaredMethod("testSubString");
			me.invoke(ts, null);
		}
		
		public static List<String> resolveTaxData(String data){
			if(null!=data && data.trim().length()>0){
				
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
		public static void main(String[] args) {
			
			System.out.println(System.getProperty("java.io.tmpdir"));
			
		}
		
		
		

}
