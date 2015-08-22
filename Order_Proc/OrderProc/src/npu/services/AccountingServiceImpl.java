package npu.services;

import npu.domain.Order;

public class AccountingServiceImpl implements AccountingService {

	private TaxService taxService;

	public void recordNewOrder(Order order) {

	}

	public void setTaxService(TaxService taxService) {
		this.taxService = taxService;
	}

	public double ComputeTax(Order order) {

		return taxService.computeTax(order);

	}
}
