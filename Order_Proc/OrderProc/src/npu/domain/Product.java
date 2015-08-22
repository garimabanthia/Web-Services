package npu.domain;

public class Product {

	private String name;
	private double price;
	private int prodQuantity;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(double price) {
		this.price = price;
	}

	
	public int getProdQuantity() {
		return prodQuantity;
		
	}
	
	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice () {
		return price;
	}
	
	public void displayProdDetails() {
		System.out.println("Product Name: "  + name);
		System.out.println("Price of Product: " +price);
		System.out.println("Quantity of Product:" + prodQuantity);
	}

}
