package br.com.pepper.specs.services.InfoService;

import java.io.IOException;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pepper.specs.models.OperationalSystemInfo;
import br.com.pepper.specs.repositories.OperationalSystemInfoRepository;

@Service
public class OperationalSystemService {

    @Autowired
    private OperationalSystemInfoRepository operationalSystemInfoRepository;

    @Autowired
    private ComandoService comandoService;

    public ResponseEntity<Object> getOperationalSystemInfo() throws IOException {       

    
        var operationalSystemInfo = new OperationalSystemInfo();

        
        operationalSystemInfo.setDomain(comandoService.comando("systeminfo | find \"Domain\""));
        operationalSystemInfo.setFirstSync(LocalDate.now());
        operationalSystemInfo.setHostname(comandoService.comando("hostname"));
        operationalSystemInfo.setIp(comandoService.comando("ipconfig | find \"IPv4 Address\""));
        operationalSystemInfo.setLastUsername(comandoService.comando("whoami"));
        operationalSystemInfo.setOS(comandoService.comando("systeminfo | find \"OS Name\""));
        operationalSystemInfo.setStatus(comandoService.comando("systeminfo | find \"OS Version\""));
        operationalSystemInfo.setInstallDate(comandoService.comando("systeminfo | find \"Original Install Date\""));
        operationalSystemInfo.setUpTime(comandoService.comando("systeminfo | find \"System Boot Time\""));

        operationalSystemInfoRepository.save(operationalSystemInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(operationalSystemInfo);
    }
    
}