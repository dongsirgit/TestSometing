/**
 *Copyright (c) 1997, 2015,BEST WONDER CO.,LTD. All rights reserved.
 */

package com.ldm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.DOMReader;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
  * @ClassName: TestResolveXml
  * @Description: TODO
  * @author Administrator
  * @date 2015年11月2日 下午4:05:53
  */
public class TestResolveXml {
	
	/**
	  * @author Administrator
	  * @Description: 创建XML文件
	  * @param   
	  * @return void  
	  * @throws
	  * @date 2015年11月2日 下午4:29:11
	  */
	static void test1(){
		Document document = DocumentHelper.createDocument();
		Element root = DocumentHelper.createElement("student");
		document.setRootElement(root);
		root.addAttribute("name", "zhangsan");
		
		Element helloElement = root.addElement("hello");
		Element worldElement = root.addElement("world");
		helloElement.setText("hello text");
		worldElement.setText("world text");
		XMLWriter xmlWriter = new XMLWriter();
		try {
			xmlWriter.write(document);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		OutputFormat of = new OutputFormat("    ",true);
		try {
			XMLWriter xmlWriter2 = new XMLWriter(new FileOutputStream("student.xml"),of);
			xmlWriter2.write(document);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	static void test2(){
		
		try{
		
		SAXReader saxreader = new SAXReader();
		Document document = saxreader.read(new File("student.xml"));
		Element root = document.getRootElement();
		System.out.println("Root:"+root.getName());
		List<Element> list = root.elements();
		System.out.println("total child count"+list.size());
		List<Element> childList = root.elements("hello");
		System.out.println("hello child"+childList.size());
		Element worldElement = root.element("world");
		System.out.println("world child:"+worldElement.getName());
		System.out.println("迭代输出-----------------------");
		for(Iterator iter = root.elementIterator();iter.hasNext();){
			Element e = (Element) iter.next();
			System.out.println(e.attributeValue("name"));
		}
		System.out.println("用DOMReaderl--------------");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		org.w3c.dom.Document document2 = db.parse(new File("student.xml"));
		DOMReader domReader = new DOMReader();
		Document document3 = domReader.read(document2);
		Element element = document3.getRootElement();
		System.out.println("Root:"+element.getName());
		
		}catch(Exception e){
			System.out.println("出错了！！！！");
		}
		
		
		
		
	}

	public static void main(String[] args) {
//		test1();
//		test2();
		System.out.println(System.getProperty("java.io.tmpdir"));
	}
}
