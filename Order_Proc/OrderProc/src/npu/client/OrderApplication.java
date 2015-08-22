package npu.client;
import java.util.ArrayList;

import npu.domain.*;
import npu.services.*;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OrderApplication {
	public static void main(String args[]) {
		
		
		ApplicationContext container = new ClassPathXmlApplicationContext("application.xml");
		Order order;
		OrderProcessor orderProc =(OrderProcessor) container.getBean("OrderProcessor");
		TaxServiceImpl tax=(TaxServiceImpl) container.getBean("Saletax");
		InventoryServiceImpl inventoryService =(InventoryServiceImpl) container.getBean("InventoryServiceImpl");
		
		//AccountingService acctService = (AccountingService) container.getBean("acctServiceIntlRules");
		
			
		
//		order = new Order("GSX-56789");
		
		//acctService.recordNewOrder(order);
//		orderProc.newOrder(order);
//		inventoryService.adjustInventory(order);
//		

		
		
		System.out.println("Inventory before placing order" );
		System.out.println("  **************    ");
		inventoryService.printCurrentInventory();
		
		
		System.out.println("\n\nInventory after placing order " );
		System.out.println("  **************    ");
		
		Customer c1 = new Customer();
		Customer c2 = new Customer();
		Customer c3 = new Customer();
		
		c1.setName("Garima");
		c2.setName("Raunak");
		c3.setName("Mishi");
		
		c1.setState("CA");
		c2.setState("NV");
		c3.setState("AZ");
		
		Product p1 = new Product(100);
		Product p2 = new Product(200);
		Product p3 = new Product(300);
		

		p1.setName("Refrigerator");
		p2.setName("Microwave");
		p3.setName("Washing Machine");
		
		OrderItem item1 = new OrderItem(p1,2);
		OrderItem item2 = new OrderItem(p2,2);
		OrderItem item3 = new OrderItem(p3,3);
		
		
		Order o1 = new Order();
		Order o2 = new Order();

		
		o1.addItem(item1);
		o1.addItem(item2);
		o1.addItem(item3);
		o1.setCustomer(c1);
//		o1.setCustomer(c2);
//		o1.setCustomer(c3);
		
		orderProc.newOrder(o1);
		inventoryService.adjustInventory(o1);
		
//		orderProc.newOrder(o2);
//		inventoryService.adjustInventory(o2);
		
		inventoryService.printCurrentInventory();
		
		System.out.println("Order is made by "+ o1.getCustomer().getName() + " from state "+ o1.getCustomer().getState());
	}
}

