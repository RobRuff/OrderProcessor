package com.paymentService;

import java.util.ArrayList;
import java.util.List;

public class PackagingSlip {
	private Entity recipient;
	private List<Video> bonusVideos;
	
	public PackagingSlip(Entity recipient)
	{
		this.setRecipient(recipient);
	}
	
	public Entity getRecipient() {
		return recipient;
	}

	public void setRecipient(Entity recipient) {
		this.recipient = recipient;
	}

	public List<Video> getBonusVideos()
	{
		if(bonusVideos == null)
		{
			this.bonusVideos = new ArrayList<>();
		}
		return bonusVideos;
	}
	
	public void setBonusVideos(List<Video> bonusVideos)
	{
		this.bonusVideos = bonusVideos;
	}
	
	public void addBonusVideo(Video video)
	{
		getBonusVideos().add(video);
	}
}
