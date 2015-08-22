package npu.domain;

public class OrderItem {

	private int quantity;
	Product product;

	public OrderItem() {

	}
	
	public OrderItem(Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return this.quantity;
	}
}
