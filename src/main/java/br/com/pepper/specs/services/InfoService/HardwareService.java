package br.com.pepper.specs.services.InfoService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pepper.specs.models.HardwareInfo;
import br.com.pepper.specs.repositories.HardwareInfoRepository;

@Service
public class HardwareService {

    @Autowired
    private ComandoService comandoService;

    @Autowired
    private HardwareInfoRepository hardwareInfoRepository;

    public ResponseEntity<Object> getHardwareSpecification() throws IOException {

        var hardwareInfo = new HardwareInfo();
        hardwareInfo.setCams(comandoService.comando("wmic os get serial number"));
        hardwareInfo.setDeviceId(comandoService.comando("wmic os get serialnumber"));
        hardwareInfo.setDisplay(comandoService.comando("wmic desktopmonitor get Name,MonitorType,MonitorManufacturer"));
        hardwareInfo.setGraphicCard(comandoService.comando("wmic path win32_VideoController get name"));
        hardwareInfo.setHardDisk(comandoService.comando("wmic diskdrive get model, size"));
        hardwareInfo.setManufacturerAndModel(comandoService.comando("wmic computersystem get model, manufacturer"));
        hardwareInfo.setMotherBoard(comandoService.comando("wmic diskdrive get model, size"));
        hardwareInfo.setProcessor(comandoService.comando("wmic cpu get name"));
        hardwareInfo.setProductId(comandoService.comando("systeminfo | findstr \"Product ID\""));
        hardwareInfo.setmRam(comandoService.comando("systeminfo | find \"Total Physical Memory\""));

        hardwareInfoRepository.save(hardwareInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(hardwareInfo);
    }
    
}