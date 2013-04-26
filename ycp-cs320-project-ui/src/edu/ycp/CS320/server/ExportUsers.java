package edu.ycp.CS320.server;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.CS320.shared.IDatabase;
import edu.ycp.CS320.shared.User;

public class ExportUsers extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String pathInfo = req.getPathInfo();
		
		//writing path info and success upon...success
		System.out.println("Path is: " + pathInfo);
		
		resp.setStatus(HttpServletResponse.SC_OK);
		resp.setContentType("text/plain");
		resp.getWriter().write("Success!! \n");
		
		//printing out all users in database
		IDatabase db = DatabaseSingleton.instance();
		Map<Integer, User> users = db.getUsersFromDB();		
		
		Iterator<Entry<Integer, User>> usersIt = users.entrySet().iterator();
		while(usersIt.hasNext()){
			resp.getWriter().write(usersIt.next().getValue().getUsername() + "\n" );
		}
	}
}
