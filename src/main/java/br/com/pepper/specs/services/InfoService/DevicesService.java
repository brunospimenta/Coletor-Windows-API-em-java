package br.com.pepper.specs.services.InfoService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pepper.specs.models.DevicesInfo;
import br.com.pepper.specs.repositories.DevicesInfoRepository;

@Service
public class DevicesService {

    @Autowired
    private ComandoService comandoService;
    
    @Autowired
    private DevicesInfoRepository devicesInfoRepository;

    public ResponseEntity<Object> getDevicesInfo() throws IOException {
        var devicesInfo = new DevicesInfo();

        devicesInfo.setAudioDevice(comandoService.comando("wmic path win32_SoundDevice get name"));
        devicesInfo.setNetworkdAdapter(comandoService.comando("wmic nic get AdapterType, Name, Installed"));
        devicesInfo.setOthersDevices(comandoService.comando("pnputil /enum-devices | findstr USB"));

        devicesInfoRepository.save(devicesInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(devicesInfo);
    }
    
}