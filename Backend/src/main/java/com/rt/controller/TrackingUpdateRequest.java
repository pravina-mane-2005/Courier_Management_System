package com.rt.controller;

import com.rt.entity.Courier;
import com.rt.entity.DeliveryStaff;

public class TrackingUpdateRequest {
    private Courier courier;
    private DeliveryStaff staff;
    private String status;
	public Courier getCourier() {
		return courier;
	}
	public void setCourier(Courier courier) {
		this.courier = courier;
	}
	public DeliveryStaff getStaff() {
		return staff;
	}
	public void setStaff(DeliveryStaff staff) {
		this.staff = staff;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
    
    
}
