package app.CPA.frontend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.CPA.frontend.model.Product;
import app.CPA.util.ConnectionUtil;

public class ProductDAO {
	
	public boolean create(Product newProduct) {
		Connection connection = ConnectionUtil.getConnection();
		boolean isSuccessful = false;
		
		try {
			PreparedStatement statement = connection.prepareStatement("insert into product (productTypeId, supplierId, productName, productPrice) values (?, ?, ?, ?)");
			statement.setInt(1, newProduct.getProductTypeId());
			statement.setInt(2, newProduct.getSupplierId());
			statement.setString(3, newProduct.getProductName());
			statement.setBigDecimal(4, newProduct.getProductPrice());
			
			int rowsAdded = statement.executeUpdate();
			
			if (rowsAdded > 0) {
				isSuccessful = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return isSuccessful;
	}

}
