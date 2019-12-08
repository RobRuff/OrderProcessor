package com.paymentService;

public class PackagingManager {
	private int totalSlipsSent;
	
	public PackagingManager()
	{
		setTotalSlipsSent(0);
	}
	
	public int getTotalSlipsSent() {
		return totalSlipsSent;
	}

	public void setTotalSlipsSent(int totalSlipsSent) {
		this.totalSlipsSent = totalSlipsSent;
	}

	public void sendPackagingSlip(PackagingSlip packagingSlip)
	{
		setTotalSlipsSent(getTotalSlipsSent() + 1);
		// send PackagingSlip
	}
	
}
