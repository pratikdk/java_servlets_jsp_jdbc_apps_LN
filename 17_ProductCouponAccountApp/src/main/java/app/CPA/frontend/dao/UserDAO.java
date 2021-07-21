package app.CPA.frontend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.CPA.frontend.model.User;
import app.CPA.util.ConnectionUtil;

public class UserDAO {
	// create 
	// delete
	// modify
	// select
	
	public boolean create(User newUser) {
		Connection connection = ConnectionUtil.getConnection();
		boolean isSuccessful = false;
		try {
			PreparedStatement statement = connection.prepareStatement("insert into user (username, password) values(?, ?)");
			statement.setString(1, newUser.getUsername());
			statement.setString(2, newUser.getPassword());
			
			int rowsAdded = statement.executeUpdate();
			
			if (rowsAdded > 0) {
				isSuccessful = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isSuccessful;
	}
	
	public boolean find(User user) {
		Connection connection = ConnectionUtil.getConnection();
		boolean hasFound = false;
		
		try {
			PreparedStatement statement = connection.prepareStatement("select * from user where username = ? and password = ?");
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getPassword());
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				user.setUserId(resultSet.getInt(1));
				hasFound = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hasFound;
	}
}
