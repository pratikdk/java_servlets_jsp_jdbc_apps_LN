package app.CPA.frontend.model;

public class ProductTypes {
	private int productTypeId;
	private String productType;
	
	public int getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(int productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	@Override
	public String toString() {
		return "<h2>ProductType</h2> <br/>productTypeId=" + productTypeId + ", <br/>productType=" + productType;
	}
}
