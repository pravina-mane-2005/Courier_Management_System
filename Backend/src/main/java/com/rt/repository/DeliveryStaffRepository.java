package com.rt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rt.entity.DeliveryStaff;

@Repository
public interface DeliveryStaffRepository extends JpaRepository<DeliveryStaff, Integer>{


}
