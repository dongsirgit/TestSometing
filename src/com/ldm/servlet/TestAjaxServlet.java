/**
 *Copyright (c) 1997, 2015,BEST WONDER CO.,LTD. All rights reserved.
 */

package com.ldm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
  * @ClassName: TestAjaxServlet
  * @Description: TODO
  * @author Administrator
  * @date 2015年12月18日 下午5:22:49
  */
@SuppressWarnings("serial")
public class TestAjaxServlet extends HttpServlet {

	public void init() throws ServletException {
		super.init();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if("1".equals(id)){
			resp.setCharacterEncoding("UTF8");
			PrintWriter pw = resp.getWriter();
			pw.println("{msg:'登录成功！'}");
			pw.flush();
			pw.close();
		}
	}

}
