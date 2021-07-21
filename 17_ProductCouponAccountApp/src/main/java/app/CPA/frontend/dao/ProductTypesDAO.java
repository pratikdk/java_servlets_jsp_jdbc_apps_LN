package app.CPA.frontend.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.CPA.frontend.model.ProductTypes;
import app.CPA.util.ConnectionUtil;

public class ProductTypesDAO {
	
	public List<ProductTypes> selectAll() {
		//Connection connection;
		List<ProductTypes> productTypesList = new ArrayList<ProductTypes>();
		try (Connection connection = ConnectionUtil.getConnection();
				PreparedStatement statement = connection.prepareStatement("select * from productTypes");) {
			
			ResultSet rs = statement.executeQuery();
			
			while (rs.next()) {
				ProductTypes productType = new ProductTypes();
				productType.setProductTypeId(rs.getInt(1));
				productType.setProductType(rs.getString(2));
				productTypesList.add(productType);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productTypesList;
	}
}
