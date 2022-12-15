package br.com.pepper.specs.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pepper.specs.services.InfoService.ApplicationsService;
import br.com.pepper.specs.services.InfoService.DevicesService;
import br.com.pepper.specs.services.InfoService.DriversAndOthersService;
import br.com.pepper.specs.services.InfoService.HardwareService;
import br.com.pepper.specs.services.InfoService.OperationalSystemService;
import br.com.pepper.specs.services.InfoService.SpecificationService;

@RestController
public class SpecificationController {
    
    @Autowired
    private SpecificationService specificationService;

    @Autowired
    private ApplicationsService applicationsService;

    @Autowired
    private HardwareService hardwareService;

    @Autowired
    private DevicesService devicesService;

    @Autowired
    private DriversAndOthersService driversAndOthersService;

    @Autowired
    private OperationalSystemService operationalSystemService;

    @GetMapping
    public ResponseEntity<Object> getAllSpecificationsInDB(){

        return ResponseEntity.status(HttpStatus.OK).body(specificationService.findAll());
    }

    @GetMapping("/All")
    public ResponseEntity<Object> getAllComputerSpecification() throws IOException{
       
        return specificationService.getAllSpecification();

    }

    @GetMapping("/HardwareInfo")
    public ResponseEntity<Object> getHardwareSpecification() throws IOException{

        return hardwareService.getHardwareSpecification();
    }

    @GetMapping("/DevicesInfo")
    public ResponseEntity<Object> getDevicesInfo() throws IOException{

        return devicesService.getDevicesInfo();
    }

    @GetMapping("/ApplicationsInfo")
    public ResponseEntity<Object> getApplicationInfo() throws IOException{

        return applicationsService.getApplicationInfo();
    }

    @GetMapping("/DriversAndOthersInfo")
    public ResponseEntity<Object> getDriversAndOthersInfo() throws IOException{

        return driversAndOthersService.getDriversAndOthersInfo();
    }

    @GetMapping("/OperationSystemInfo")
    public ResponseEntity<Object> getOperationSystemInfo() throws IOException{
        return operationalSystemService.getOperationalSystemInfo();
    }    
}