package app.CPA.frontend.model;

public class ProductMarketplace {
	private int productMarketplaceId;
	private int productId;
	public int getProductMarketplaceId() {
		return productMarketplaceId;
	}
	public void setProductMarketplaceId(int productMarketplaceId) {
		this.productMarketplaceId = productMarketplaceId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@Override
	public String toString() {
		return "<h2>ProductMarketplace<h2> <br/>productMarketplaceId=" + productMarketplaceId + ", <br/>productId=" + productId;
	}
}
