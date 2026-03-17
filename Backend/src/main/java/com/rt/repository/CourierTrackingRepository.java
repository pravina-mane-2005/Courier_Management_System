package com.rt.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.rt.entity.Courier;
import com.rt.entity.CourierTracking;
import com.rt.entity.User;

public interface CourierTrackingRepository extends JpaRepository<CourierTracking,Integer> {

    List<CourierTracking> findByCourierIdOrderByUpdatedAtDesc(int courierId);

	List<CourierTracking> findByCourier(Courier courier);
	List<CourierTracking> findByUpdatedBy(User user);
	List<CourierTracking> findByCourierOrderByUpdatedAtDesc(Courier courier);
    

}