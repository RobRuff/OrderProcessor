package com.paymentService;

public class EmailManager {
	private int emailsSent;
	
	public void sendEmail(String emailAddress, String messageBody)
	{
		// send email
		setEmailsSent(getEmailsSent() + 1);
	}

	public int getEmailsSent() {
		return emailsSent;
	}

	public void setEmailsSent(int emailsSent) {
		this.emailsSent = emailsSent;
	}
}
