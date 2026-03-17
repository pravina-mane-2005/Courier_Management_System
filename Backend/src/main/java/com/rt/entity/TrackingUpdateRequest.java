package com.rt.entity;

public class TrackingUpdateRequest {
    private String status;
    private Courier courier;

    // getters and setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Courier getCourier() { return courier; }
    public void setCourier(Courier courier) { this.courier = courier; }
}
