package com.bit.servlet.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.servlet.dao.AddressbookDao;
import com.bit.servlet.dao.AddressbookDaoOrclImpl;
import com.bit.servlet.model.AddressbookVo;
@WebServlet("/AddressbookServlet")
public class AddressbookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AddressbookDao addressbookdao = new AddressbookDaoOrclImpl();
       


	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		AddressbookDao addressbookdao = new AddressbookDaoOrclImpl();
		
//		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/registerform.jsp");
//		rd.forward(req, resp);
		
//		String field_ = req.getParameter("f");
//		String query_ = req.getParameter("q");
//	    
//		String field = "search";
//        if (field_ != null)
//        	field = field_;
//        String query ="";
//        if (query_ != null)
//        	query = query_ ;
//        NoticeService service = new NoticeService();
//        List<AddressbookVo> list = addressbookdao.search(field,query,1);
        
        
    

	String action = req.getParameter("action");

	System.out.println(action);
	
	if("search".equals(action)) {
		String keyword = req.getParameter("keyword");
		List<AddressbookVo> list = addressbookdao.search(keyword);
		req.setAttribute("list", list);
		req.setAttribute("keyword", keyword);
		RequestDispatcher rd = req.getRequestDispatcher("/");
		rd.forward(req, resp);
	}else if("insertform".equals(action)){
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/registerform.jsp");
		rd.forward(req, resp);
	}else {
		List<AddressbookVo> list = addressbookdao.getList();
		req.setAttribute("list", list);
		RequestDispatcher rd = req.getRequestDispatcher("/");
		rd.forward(req, resp);
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
