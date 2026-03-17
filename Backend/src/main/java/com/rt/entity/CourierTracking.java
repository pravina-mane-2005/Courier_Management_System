package com.rt.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="courier_tracking")
public class CourierTracking {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;

@ManyToOne
@JoinColumn(name="courier_id")
private Courier courier;

private String location;

private String status;

@ManyToOne
@JoinColumn(name="updated_by")
private User updatedBy;

@Temporal(TemporalType.TIMESTAMP)
@Column(name="updated_at")
private Date updatedAt;

public CourierTracking(){}

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

public String getLocation() {
return location;
}

public void setLocation(String location) {
this.location = location;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public User getUpdatedBy() {
return updatedBy;
}

public void setUpdatedBy(User updatedBy) {
this.updatedBy = updatedBy;
}

public Date getUpdatedAt() {
return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
this.updatedAt = updatedAt;
}

}