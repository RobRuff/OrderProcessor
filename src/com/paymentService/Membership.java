package com.paymentService;

public class Membership {
	private boolean isActive;
	private boolean isUpgraded;
	private String ownerName;
	private String ownerEmail;
	
	// Can only create new or active memberships
	public Membership(boolean isNewMember, String ownerName, String ownerEmail)
	{
		isActive = !isNewMember;
		isUpgraded = false;
		this.ownerName = ownerName;
		this.ownerEmail = ownerEmail;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isUpgraded() {
		return isUpgraded;
	}

	public void setUpgraded(boolean isUpgraded) {
		this.isUpgraded = isUpgraded;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerEmail() {
		return ownerEmail;
	}

	public void setOwnerEmail(String ownerEmail) {
		this.ownerEmail = ownerEmail;
	}
}
