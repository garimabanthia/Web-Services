package npu.domain;

import java.util.ArrayList;

import npu.services.InventoryServiceImpl;

public class Order {
	private String code;
	private double subtotal;
	private double total;
	private double tax;
	ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
	Customer customer;
	InventoryServiceImpl isi = new InventoryServiceImpl();

	// Product product;
	public Order() {
	
	}
	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public Order(String newOrderCode) {
		code = newOrderCode;
	}

	public void addItem(OrderItem item) {

		if (orderItemList == null || orderItemList.size() == 0) {
			orderItemList.add(0, item);
			orderItemList.get(0).setQuantity(1);
			subTotalCalc();
			return;
		}

		for (int i = 0; i < orderItemList.size(); i++) {
			String prodName = orderItemList.get(i).product.getName();

			if (!(prodName.equals(item.product.getName()))) {
				continue;
			} else {
				orderItemList.get(i).setQuantity(
						orderItemList.get(i).getQuantity() + 1);
				subTotalCalc();
				return;
			}

		}
		orderItemList.add(item);
		subTotalCalc();

	}

	public void removeProduct(Product prod) {

		if (orderItemList == null || orderItemList.size() == 0) {
			return;
		}

		for (int i = 0; i < orderItemList.size(); i++) {

			if (orderItemList.get(i).getQuantity() == 0) {
				orderItemList.remove(orderItemList.get(i));
			}

			if ((orderItemList.get(i).product.getName()).equals(prod.getName())) {
				orderItemList.get(i).setQuantity(
						orderItemList.get(i).getQuantity() - 1);

			}
		}

	}

	public void subTotalCalc() {
		if (orderItemList == null || orderItemList.size() == 0) {
			System.out.println("Oops! orderItemList == null OR orderItemList.size() == 0, SIZE = " + orderItemList.size());
			return;
		}
		
		for (int i = 0; i < orderItemList.size(); i++) {
			
			if ((orderItemList.get(i).getProduct().getName()).equals("Refrigerator")) {
				subtotal += ((orderItemList.get(i).getQuantity()) * 100);
			} else if ((orderItemList.get(i).getProduct().getName()).equals("Microwave")) {
				subtotal += ((orderItemList.get(i).getQuantity()) * 200);
			} else if ((orderItemList.get(i).getProduct().getName()).equals("Washing Machine")) {
				subtotal += ((orderItemList.get(i).getQuantity()) * 300);
			}
		}
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<OrderItem> getOrderItem() {
		return orderItemList;
	}

	public void setOrderItem(ArrayList<OrderItem> orderItemList) {
		this.orderItemList = orderItemList;
	}

}
