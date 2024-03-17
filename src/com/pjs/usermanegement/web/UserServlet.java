	package com.pjs.usermanegement.web;
	
	import java.io.IOException;
	import java.net.HttpRetryException;
	import java.sql.SQLException;
	import java.util.List;
	
	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	import com.pjs.usermanagement.dao.UserDAO;
	import com.pjs.usermanegement.model.User;
	
	/**
	 * Servlet implementation class UserServlet
	 */
	@WebServlet("/")
	public class UserServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		 private UserDAO userDAO;   
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public UserServlet() {
	      this.userDAO=new UserDAO();
	    }
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action= request.getServletPath();
			System.out.println("action " + action);
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				try {
					insertUser(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    break;
			case "/delete" :
				try {
					deleteUser(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case "/edit":
				try {
					showEditForm(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			case "/update":
				try {
					updateUser(request, response);
				} catch (Throwable e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
			default :
				try {
					listUser(request, response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break ;
			}
		}
		
		
		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	           this.doGet(request, response);
		}
	
	
		private void showNewForm(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		
		private void insertUser(HttpServletRequest request ,HttpServletResponse response) throws Exception  {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String phone_number = request.getParameter("phone_number");
			String gender = request.getParameter("gender");
			User user= new User(name,address,phone_number,gender);
			
			userDAO.insertUser(user);
			response.sendRedirect("list");
			
		}
		
		private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String phone_number=request.getParameter("phone_number");
			userDAO.deleteUser(phone_number);
			response.sendRedirect("list");
			
		}
		
		private void showEditForm(HttpServletRequest request,HttpServletResponse response) throws Exception {
			String phone_number=request.getParameter("phone_number");
			User exitingUser=userDAO.selectUser(phone_number);
			RequestDispatcher dispatcher= request.getRequestDispatcher("index.jsp");
			request.setAttribute("exitingUser", exitingUser);
			dispatcher.forward(request, response);
		}
		
		private void updateUser(HttpServletRequest request, HttpServletResponse response) throws Throwable {
			String name= request.getParameter("name");
			String address= request.getParameter("address");
			String phone_number= request.getParameter("phone_number");
			String gender = request.getParameter("gender");
			
			User user = new User(name,address,phone_number,gender);
			userDAO.updateUser(user);
			response.sendRedirect("list");
			
		}
		
		public void listUser(HttpServletRequest request , HttpServletResponse response) throws Exception {
			List<User> listUser = userDAO.selectAllUser();
			System.out.println("listUser" +listUser);
			request.setAttribute("listUser", listUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
			dispatcher.forward(request, response);
		}
	}
