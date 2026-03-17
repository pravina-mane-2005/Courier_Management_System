package com.rt.entity;

public class CourierStatsDTO {
    private long totalUsers;
    private long totalCouriers;
    private long pending;
    private long inProgress;

    public CourierStatsDTO() {}

    public CourierStatsDTO(long totalUsers, long totalCouriers, long pending, long inProgress) {
        this.totalUsers = totalUsers;
        this.totalCouriers = totalCouriers;
        this.pending = pending;
        this.inProgress = inProgress;
    }

    // Getters & Setters
    public long getTotalUsers() { return totalUsers; }
    public void setTotalUsers(long totalUsers) { this.totalUsers = totalUsers; }

    public long getTotalCouriers() { return totalCouriers; }
    public void setTotalCouriers(long totalCouriers) { this.totalCouriers = totalCouriers; }

    public long getPending() { return pending; }
    public void setPending(long pending) { this.pending = pending; }

    public long getInProgress() { return inProgress; }
    public void setInProgress(long inProgress) { this.inProgress = inProgress; }
}