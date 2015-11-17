package com.ldm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestUpload
 */
public class TestUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestUpload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("test");
		System.out.println(TestUpload.class+",,进来了");
		request.getRequestDispatcher("/jsp/success.jsp").forward(request, response);
		
	}

}
