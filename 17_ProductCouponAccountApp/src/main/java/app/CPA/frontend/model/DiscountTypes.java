package app.CPA.frontend.model;

public class DiscountTypes {
	private int discountTypeId;
	private String discountType;
	public int getDiscountTypeId() {
		return discountTypeId;
	}
	public void setDiscountTypeId(int discountTypeId) {
		this.discountTypeId = discountTypeId;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
	
	@Override
	public String toString() {
		return "<h2>DiscountTypes</h2> <br/>discountTypeId=" + discountTypeId + ", <br/>discountType=" + discountType;
	}
}
