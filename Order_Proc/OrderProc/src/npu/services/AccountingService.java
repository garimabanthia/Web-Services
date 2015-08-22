package npu.services;
import npu.domain.*;

public interface AccountingService {
	public void recordNewOrder(Order order);
	public double ComputeTax(Order order);
}
