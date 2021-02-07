package com.demo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/web_student_tracker?serverTimezone=UTC";
		String username = "root";
		String password = "root";
		
		try {
			System.out.println("connect to database : " + jdbcUrl);
			
			Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			
			if(conn != null) {
				System.out.println("connect successfully");
			} else {
				System.out.println("connect failed");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
