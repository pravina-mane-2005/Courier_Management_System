package com.rt.entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="payments")
public class Payment {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@ManyToOne
@JoinColumn(name="courier_id")
private Courier courier;

private double amount;

@Column(name="payment_status")
private String paymentStatus;

@Column(name="payment_method")
private String paymentMethod;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="payment_date")
private Date paymentDate;

public Payment(){}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public Courier getCourier() {
return courier;
}

public void setCourier(Courier courier) {
this.courier = courier;
}

public double getAmount() {
return amount;
}

public void setAmount(double amount) {
this.amount = amount;
}

public String getPaymentStatus() {
return paymentStatus;
}

public void setPaymentStatus(String paymentStatus) {
this.paymentStatus = paymentStatus;
}

public String getPaymentMethod() {
return paymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
this.paymentMethod = paymentMethod;
}

public Date getPaymentDate() {
return paymentDate;
}

public void setPaymentDate(Date paymentDate) {
this.paymentDate = paymentDate;
}

}