package com.cab.netlink.driverservice.resource;


import com.cab.netlink.driverservice.model.DriverModel;
import com.cab.netlink.driverservice.model.User;
import com.cab.netlink.driverservice.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/driver-service")
public class DriverResource {

    @Autowired
    DriverRepository driverRepository ;

    @Autowired

    RestTemplate restTemplate;

    @GetMapping("driver/{driverid}")
    public DriverModel getDriver(@PathVariable("driverid") String driverId){

        return driverRepository.findDriverById(Integer.valueOf(driverId));
    }

    @GetMapping("availabledrivers")
    private List <DriverModel> getDriverByAvalability(){

        return driverRepository.findDriverByDriverStatus("Available");
    }

    @PostMapping("driver/updateStatus")
    private String updateDriverStatus(@RequestBody DriverModel driverModel){
        DriverModel driverToPersist = driverRepository.findDriverById(driverModel.getId());
        if(driverToPersist.getCurrent_customer()==null){
            driverToPersist.setCurrent_customer(driverModel.getCurrent_customer());
        }
        else{
            driverToPersist.setCurrent_customer(null);
        }

        if(driverToPersist.getDriverStatus().equalsIgnoreCase("Available")){
            driverToPersist.setDriverStatus("Busy");
        }
        else{
            driverToPersist.setDriverStatus("Available");
        }

        driverRepository.save(driverToPersist);
        return "Driver Status Updated";

    }

    @GetMapping("/driverListStatus")

    private List <DriverModel> getDriverAndCustomer(){

        List <DriverModel> drivers = driverRepository.findAll();
        List<DriverModel> returningDrivers = new ArrayList<DriverModel>();

        for(DriverModel d : drivers ){

            ResponseEntity<User> user = restTemplate.exchange("http://user-service/user-service/getUserId/" + d.getCurrent_customer(), HttpMethod.GET,
                    null, new ParameterizedTypeReference<User>() {
                    });
            d.setCustomer_name(user.getBody().getFirstName());
            returningDrivers.add(d);

        }
        return  returningDrivers;
    }

    @PostMapping("driver")
    private  String createDriver (@RequestBody DriverModel driverModel){
        driverRepository.save(driverModel);

        return  "Driver Created Succesfully with Driver name " +driverModel.getDriverName();
    }


}
