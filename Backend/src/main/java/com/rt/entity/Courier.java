package com.rt.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="couriers")
public class Courier {

	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@Column(name="tracking_number")
private String trackingNumber;

@ManyToOne
@JoinColumn(name="sender_id")
private User sender;

@Column(name="receiver_name")
private String receiverName;

@Column(name="receiver_phone")
private String receiverPhone;

@Column(name="source_address")
private String sourceAddress;

@Column(name="destination_address")
private String destinationAddress;

private double weight;
private double price;

@Column(name="courier_type")
private String courierType;

private String status;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="created_at")
private Date createdAt;
@ManyToOne
@JoinColumn(name="staff_id") 
private DeliveryStaff staff;



public DeliveryStaff getStaff() {
    return staff;
}

public void setStaff(DeliveryStaff staff) {
    this.staff = staff;
}


public Courier(){}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public String getTrackingNumber() {
return trackingNumber;
}

public void setTrackingNumber(String trackingNumber) {
this.trackingNumber = trackingNumber;
}

public User getSender() {
return sender;
}

public void setSender(User sender) {
this.sender = sender;
}

public String getReceiverName() {
return receiverName;
}

public void setReceiverName(String receiverName) {
this.receiverName = receiverName;
}

public String getReceiverPhone() {
return receiverPhone;
}

public void setReceiverPhone(String receiverPhone) {
this.receiverPhone = receiverPhone;
}

public String getSourceAddress() {
return sourceAddress;
}

public void setSourceAddress(String sourceAddress) {
this.sourceAddress = sourceAddress;
}

public String getDestinationAddress() {
return destinationAddress;
}

public void setDestinationAddress(String destinationAddress) {
this.destinationAddress = destinationAddress;
}

public double getWeight() {
return weight;
}

public void setWeight(double weight) {
this.weight = weight;
}

public double getPrice() {
return price;
}

public void setPrice(double price) {
this.price = price;
}

public String getCourierType() {
return courierType;
}

public void setCourierType(String courierType) {
this.courierType = courierType;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public Date getCreatedAt() {
return createdAt;
}

public void setCreatedAt(Date createdAt) {
this.createdAt = createdAt;
}

@OneToMany(mappedBy = "courier",
cascade = CascadeType.ALL,
orphanRemoval = true,
fetch = FetchType.LAZY)
@JsonIgnoreProperties("courier")
private List<CourierTracking> courierTrackings;

// Getter and Setter
public List<CourierTracking> getCourierTrackings() {
    return courierTrackings;
}

public void setCourierTrackings(List<CourierTracking> courierTrackings) {
    this.courierTrackings = courierTrackings;
}


}