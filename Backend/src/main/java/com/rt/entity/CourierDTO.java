package com.rt.entity;

public class CourierDTO {
    private String trackingNumber;
    private String senderName;
    private String receiverName;
    private String status;
    private String staffName;
    
    public CourierDTO() {}
    

    public CourierDTO(Courier c) {
        this.trackingNumber = c.getTrackingNumber();
        this.senderName = c.getSender() != null ? c.getSender().getName() : "";
        this.receiverName = c.getReceiverName();
        this.status = c.getStatus();
        this.staffName = c.getStaff() != null ? c.getStaff().getName() : null;
    }


	public String getTrackingNumber() {
		return trackingNumber;
	}


	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}


	public String getSenderName() {
		return senderName;
	}


	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}


	public String getReceiverName() {
		return receiverName;
	}


	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getStaffName() {
		return staffName;
	}


	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
    

    // getters and setters
}