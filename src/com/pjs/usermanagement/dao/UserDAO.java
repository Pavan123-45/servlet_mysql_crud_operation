package com.pjs.usermanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pjs.usermanegement.model.User;

public class UserDAO {
	                          
	private String jdbcURL = "jdbc:mysql://localhost:3306/user_management?user=root&password=admin";

	private static String INSERT_USER = "INSERT into user_management.user value (?,?,?,?)";

	private static String SELECT_USER_BY_PHONE_NUMBER = "select * from user_management.user where phone_number=?";
	private static String SELECT_ALL_USERS = "select * from  user_management.user";
	private static String DELETE_USER = "delete from  user_management.user where phone_number =?";
	private static String UPDATE_USER = "update  user_management.user set name=?, address=?, phone_number=?, gender=? where phone_number=?";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public void insertUser(User user) throws Exception {
		Connection connection =getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER); 
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getAddress());
		preparedStatement.setString(3, user.getPhone_number());
		preparedStatement.setString(4, user.getGender());
		preparedStatement.executeUpdate();
		
	}
	
	public boolean updateUser(User user) throws Exception{
		boolean rowUpdate;
		Connection connection = getConnection();
		PreparedStatement preparedStatement= connection.prepareStatement(UPDATE_USER);
		preparedStatement.setString(1, user.getName());
		preparedStatement.setString(2, user.getAddress());
		preparedStatement.setString(3, user.getPhone_number());
		preparedStatement.setString(4, user.getGender());
		preparedStatement.setString(5, user.getPhone_number());
		preparedStatement.executeUpdate();
		rowUpdate = preparedStatement.executeUpdate()>0;
		return rowUpdate;
		
	}
	
	public User selectUser(String phone_number) throws Exception {
		User user= null;
		Connection connection = getConnection();
		PreparedStatement preparedStatement= connection.prepareStatement(SELECT_USER_BY_PHONE_NUMBER);
		preparedStatement.setString(1, phone_number);
		
		ResultSet rs=preparedStatement.executeQuery();
		
		while (rs.next()) {
			String name=rs.getString("name");
			String address=rs.getString("address");
			String gender=rs.getString("gender");
			user= new User(name,address,phone_number, gender);
			}
		return user;
	}
	
	public List<User> selectAllUser() throws Exception {
		List<User> users = new ArrayList(); 
		Connection connection = getConnection();
		PreparedStatement preparedStatement= connection.prepareStatement(SELECT_ALL_USERS);
		
//  		System.out.println(preparedStatement);
		
		ResultSet rs=preparedStatement.executeQuery();
		
		while (rs.next()) {
			String name=rs.getString("name");
			String address=rs.getString("address");
			String phone_number =rs.getString("phone_number");
			String gender=rs.getString("gender");
			User user1= new User(name,address,phone_number,gender);
			users.add(user1);
			}
		return users;
	}
	
	public boolean deleteUser(String phone_number) throws Exception {
		boolean rowDeleted;
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(DELETE_USER);
		preparedStatement.setString(1, phone_number);
		rowDeleted=preparedStatement.executeUpdate()>0;
		return rowDeleted;
		
	}


}
