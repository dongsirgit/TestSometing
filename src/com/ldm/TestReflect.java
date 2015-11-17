/**
 *Copyright (c) 1997, 2015,BEST WONDER CO.,LTD. All rights reserved.
 */

package com.ldm;

/**
  * @ClassName: TestReflect
  * @Description: TODO
  * @author Administrator
  * @date 2015年10月15日 上午9:49:12
  */
public class TestReflect {

	public static void main(String[] args) {
		System.out.println("全类名："+Demo.class.getName());
		for(java.lang.reflect.Method mt:Demo.class.getDeclaredMethods()){
			System.out.println("方法名："+mt.getName());
		}
		Demo demo = new Demo();
		System.out.println("Demo实例："+demo.getClass().getName());
		
	}
}
class Demo {
	
	String ss(int a){
		if(a==2){
			return "2";
		}else{
			return "";
		}
	}
	
}
