package app.CPA.frontend.model;

import java.math.BigDecimal;

public class Coupon {
	private int couponId;
	private int discountTypeId;
	private int productId;
	private BigDecimal discountValue;
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public int getDiscountTypeId() {
		return discountTypeId;
	}
	public void setDiscountTypeId(int discountTypeId) {
		this.discountTypeId = discountTypeId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public BigDecimal getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(BigDecimal discountValue) {
		this.discountValue = discountValue;
	}
	
	@Override
	public String toString() {
		return "<h2>Coupon</h2> <br/>couponId=" + couponId + ", <br/>discountTypeId=" + discountTypeId + ", <br/>productId=" + productId
				+ ", <br/>discountValue=" + discountValue;
	}
}
