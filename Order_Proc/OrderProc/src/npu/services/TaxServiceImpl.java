package npu.services;

import java.util.Map;

import npu.domain.Order;

public class TaxServiceImpl implements TaxService {

	private Map<String, Double> tax;

	public TaxServiceImpl() {

	}

	public Map<String, Double> getTax() {
		return tax;
	}

	public void setTax(Map<String, Double> tax) {
		this.tax = tax;
	}

	@Override
	public double computeTax(Order order) {
		//	double salesTax=0.0;
//		System.out.println("order.getCustomer().getState() = " + order.getCustomer().getState());
		for (Map.Entry<String, Double> salentry : tax.entrySet()) {
			if (salentry.getKey().equals(order.getCustomer().getState())) {
				order.setTax(salentry.getValue());
			}
		}
		return order.getTax();
	}
}

// if(map.entry<String,double> entry: saleTax.entryset()
// .equals(order.getCustomer().getState()) )
// salesTax = (order.getSubtotal() * tax);
//

// return salesTax;
// }
// }

// public Map<String, Double> gettax() {
// return tax;
// }
// public void settax(Map<String, Double> tax) {
// this.tax = tax;
// }
// }

// public double computeTax(Order order) {
// for(Map.Entry<String,Double> salentry : statesaltax.entrySet())
// {
// if(salentry.getKey().equals(order.getC().getState()))
// {
// order.setTax(salentry.getValue());
// }
// }
// return order.getTax();
// }
// public Map<String, Double> gettax() {
// return statesaltax;
// }
// public void setStatesaltax(Map<String, Double> statesaltax) {
// this.statesaltax = statesaltax;
// }
//
// }
