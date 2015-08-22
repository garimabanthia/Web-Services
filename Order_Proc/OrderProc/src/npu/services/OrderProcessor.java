package npu.services;

import npu.domain.*;

public class OrderProcessor {
	
	private  AccountingService acctService;
	private InventoryService inventoryService;

	public AccountingService getAcctService() {
		return acctService;
	}

	public InventoryService getInventoryService() {
		return inventoryService;
	}

	public OrderProcessor() {
	}

	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}

	public void setAcctService(AccountingService acctService) {
		this.acctService = acctService;
	}

	public void newOrder(Order order) {
		// acctService.recordNewOrder(order);

		double tax = 0.0, total, subTotal = 0.0;
		tax = acctService.ComputeTax(order);
//		System.out.println("TAX = " + tax);
		order.setTax(tax);

		subTotal = order.getSubtotal();
//		System.out.println("SUBTOTAL = " + subTotal);
		
		total = subTotal + tax;
//		System.out.println("TOTAL = " + total);

		order.setTotal(total);

		inventoryService.adjustInventory(order);

	}
}