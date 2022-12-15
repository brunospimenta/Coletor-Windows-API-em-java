package br.com.pepper.specs.services.InfoService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pepper.specs.models.DriversAndOthersInfo;
import br.com.pepper.specs.repositories.DriversAndOthersInfoRepository;

@Service
public class DriversAndOthersService {

    @Autowired
    private ComandoService comandoService;

    @Autowired
    private DriversAndOthersInfoRepository driversAndOthersInfoRepository;
    
    public ResponseEntity<Object> getDriversAndOthersInfo() throws IOException {
        var driversAndOthersInfo = new DriversAndOthersInfo();
        driversAndOthersInfo.setAntiVirus(comandoService.comando(
                "wmic /Node:localhost/Namespace:\\\\root\\SecurityCenter2 Path AntiVirusProduct Get displayName"));
        driversAndOthersInfo.setFirewall(comandoService.comando("netsh advfirewall show allprofiles"));
        driversAndOthersInfo.setProxy(comandoService.comando("netsh winhttp show proxy"));

        driversAndOthersInfoRepository.save(driversAndOthersInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(driversAndOthersInfo);
    }
}