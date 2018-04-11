package com.cab.netlink.driverservice.repository;

import com.cab.netlink.driverservice.model.DriverModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DriverRepository extends JpaRepository<DriverModel, Integer> {


    DriverModel findDriverById(Integer id);
    List<DriverModel> findDriverByDriverStatus(String status);
    List<DriverModel> findAll();
}
