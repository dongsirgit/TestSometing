/**
 *Copyright (c) 1997, 2015,BEST WONDER CO.,LTD. All rights reserved.
 */

package com.ldm;

/**
  * @ClassName: TestThread2
  * @Description: 开5个线程，每个线程执行10次打印操作
  * @author Administrator
  * @date 2016年1月13日 下午6:19:27
  */
public class TestThread2 {
	
public static void main(String[] args) {
		
		for(int a=0;a<5;a++){
			new Thread(new Runnable() {
				public void run() {
					for(int i=0;i<10;i++){
						System.out.println(Thread.currentThread().getName()+": "+i);
					}
				}
			}).start();
		}
	}

}
