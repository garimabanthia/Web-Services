package npu.services;

import java.util.ArrayList;

import npu.domain.Order;
import npu.domain.OrderItem;
import npu.domain.Product;

public class InventoryServiceImpl implements InventoryService {

	//OrderItem orderItem = new OrderItem();
	
//	public OrderItem getOrderItem() {
//		return orderItem;
//	}
//
//	public void setOrderItem(OrderItem orderItem) {
//		this.orderItem = orderItem;
//	}

	// private ArrayList<OrderItem> currentOrderItemList;
	private ArrayList<Product> productList= new ArrayList<Product>();

	public InventoryServiceImpl() {

		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();

		p1.setName("Microwave");
		p2.setName("Washing Machine");
		p3.setName("Refrigerator");

		p1.setPrice(100.0);
		p2.setPrice(200.0);
		p3.setPrice(300.0);

		p1.setProdQuantity(5);
		p2.setProdQuantity(10);
		p3.setProdQuantity(15);

		productList.add(p1);
		productList.add(p2);
		productList.add(p3);

		 OrderItem oi1 = new OrderItem();
		 OrderItem oi2 = new OrderItem();
		 OrderItem oi3 = new OrderItem();
		 
		// oi1.setProduct(p1);
		// oi2.setProduct(p2);
		// oi3.setProduct(p3);
		//
		// oi1.setQuantity(5);
		// oi2.setQuantity(10);
		// oi3.setQuantity(15);

		// currentOrderItemList.add(oi1);
		// currentOrderItemList.add(oi2);
		// currentOrderItemList.add(oi3);

	}

	public ArrayList<Product> getProductList() {
		return productList;
	}

	public void setProductList(ArrayList<Product> productList) {
		this.productList = productList;
	}

	public void adjustInventory(Order order) {
		if (productList.size() == 0) {
			return;
		}

		for (int i = 0; i < productList.size(); i++) {

			ArrayList<OrderItem> orderList = order.getOrderItem();
			
			if (orderList == null || orderList.size() == 0) {
				return;
			}
			
			for (int j = 0; j < orderList.size(); j++) {

				String orderListName = orderList.get(j).getProduct().getName();
				Product product = orderList.get(j).getProduct();

				if (productList.get(i).getName()
						.equalsIgnoreCase(product.getName())) {

//					if (orderList.get(i).getQuantity() <= productList.get(i)
//							.getProdQuantity()) {
					
						int inventory = (productList.get(i).getProdQuantity() - order.getOrderItem().get(j).getQuantity());
						productList.get(i).setProdQuantity(inventory);

					
				}
			}

		}

	}

	public void printCurrentInventory() {
		for(int i=0;i<productList.size();i++){
			Product prod=new Product();
			prod=productList.get(i);
			prod.displayProdDetails();
	}

}
}



// @Override
// public void adjustInventory(Order order) {
//
// int quantity = 0;
// if (currentOrderItemList.size() == 0
// || order.getOrderItem().size() == 0) {
// return;
// }
//
// for (int i = 0; i < order.getOrderItem().size(); i++) {
// for (int j = 0; j < currentOrderItemList.size(); j++) {
// String listProdName = currentOrderItemList.get(j).getProduct().getName();
// String orderName = order.getOrderItem().get(i).getProduct().getName();
// if (listProdName.equalsIgnoreCase(orderName)) {
// quantity =(currentOrderItemList.get(j).getQuantity() -
// order.getOrderItem().get(i).getQuantity());
// currentOrderItemList.get(j).setQuantity(quantity);
// }
// }
//
// }
// }
//
// @Override
// public void printCurrentInventory() {
// System.out.println("The number of the available stocks:");
//
// for (int i = 0; i < currentOrderItemList.size(); i++) {
//
// System.out.println("Prodct Name: "
// + currentOrderItemList.get(i).getProduct().getName());
// System.out.println("Prodct Price $: "
// + currentOrderItemList.get(i).getProduct().getPrice());
// System.out.println("Quantity of the product: "
// + currentOrderItemList.get(i).getQuantity());
//
// }
//
// }
//
// }

