package com.rt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rt.entity.Courier;
import com.rt.entity.User;


public interface CourierRepository extends JpaRepository<Courier,Integer>{

List<Courier> findBySender_Id(int senderId);

List<Courier> findByStaff_Id(int staffId);

Courier findByTrackingNumber(String trackingNumber);

boolean existsBySender(User user);

List<Courier> findBySender(User user);
// --- Count methods ---
@Query("SELECT COUNT(c) FROM Courier c")
long countTotalCouriers();

@Query("SELECT COUNT(c) FROM Courier c WHERE c.status = 'Delivered'")
long countDelivered();

@Query("SELECT COUNT(c) FROM Courier c WHERE c.status = 'In Progress'")
long countInProgress();

@Query("SELECT COUNT(c) FROM Courier c WHERE c.status = 'Pending'")
long countPending();

}