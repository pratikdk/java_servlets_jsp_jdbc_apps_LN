package app.CPA.frontend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.CPA.frontend.model.Supplier;
import app.CPA.util.ConnectionUtil;

public class SupplierDAO {
	// create 
	// delete
	// modify
	// select
	
	public boolean create(Supplier newSupplier) {
		Connection connection = ConnectionUtil.getConnection();
		boolean isSuccessful = false;
		try {
			PreparedStatement statement = connection.prepareStatement("insert into supplier (username, password) values(?, ?)");
			statement.setString(1, newSupplier.getUsername());
			statement.setString(2, newSupplier.getPassword());
			
			int rowsAdded = statement.executeUpdate();
			
			if (rowsAdded > 0) {
				isSuccessful = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return isSuccessful;
	}
	
	public boolean find(Supplier supplier) {
		Connection connection = ConnectionUtil.getConnection();
		boolean hasFound = false;
		
		try {
			PreparedStatement statement = connection.prepareStatement("select * from supplier where username = ? and password = ?");
			statement.setString(1, supplier.getUsername());
			statement.setString(2, supplier.getPassword());
			
			ResultSet resultSet = statement.executeQuery();
			
			if (resultSet.next()) {
				supplier.setSupplierId(resultSet.getInt(1));
				hasFound = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return hasFound;
	}
}
