/**
 *Copyright (c) 1997, 2015,BEST WONDER CO.,LTD. All rights reserved.
 */

package com.ldm;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
  * @ClassName: Ttt
  * @Description: TODO
  * @author Administrator
  * @date 2015年11月4日 下午3:18:55
  */
public class Ttt implements ThisIsAinterface{
	
	Logger log = Logger.getLogger(Ttt.class);
	
	public Ttt(){
		log.info("啦-------啦--------啦");
	}

	
	void meth2(){
		System.out.println("可以的！");
	}


	/**
	  * <p>Title: meth_1</p>
	  * <p>Description: </p>
	  * @see com.ldm.ThisIsAinterface#meth_1()
	  */
	@Override
	public void meth_1() {
		
	}
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("test.properties");
		Ttt t = new Ttt();
	}


}
