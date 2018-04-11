package com.cab.netlink.driverservice.model;


import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name="DriverModel")
public class DriverModel {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="driver_id")
     private Integer id ;

    @Column(name="driver_name")
     private String driverName;

    @Column(name="driver_latitude")
     private BigDecimal driver_latitude ;

    @Column(name="driver_longitude")
     private BigDecimal driver_longitude;

    @Column(name="driver_status")
     private String driverStatus;

    @Column(name="driver_current_customer")
     private Integer current_customer;

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    @Transient
    private String Customer_name;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public BigDecimal getDriver_latitude() {
        return driver_latitude;
    }

    public void setDriver_latitude(BigDecimal driver_latitude) {
        this.driver_latitude = driver_latitude;
    }

    public BigDecimal getDriver_longitude() {
        return driver_longitude;
    }

    public void setDriver_longitude(BigDecimal driver_longitude) {
        this.driver_longitude = driver_longitude;
    }

    public String getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(String driverStatus) {
        this.driverStatus = driverStatus;
    }

    public Integer getCurrent_customer() {
        return current_customer;
    }

    public void setCurrent_customer(Integer current_customer) {
        this.current_customer = current_customer;
    }
}
