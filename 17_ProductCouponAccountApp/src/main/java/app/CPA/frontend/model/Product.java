package app.CPA.frontend.model;

import java.math.BigDecimal;

public class Product {
	private int productId;
	private int productTypeId;
	private int supplierId;
	private String productName;
	private BigDecimal productPrice;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}
	
	@Override
	public String toString() {
		return "<h2>Product</h2> <br/>productId=" + productId + ", <br/>productTypeId=" + productTypeId + ", <br/>supplierId=" + supplierId
				+ ", <br/>productName=" + productName + ", <br/>productPrice=" + productPrice;
	}	
}
