package br.com.pepper.specs.services.InfoService;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pepper.specs.models.ApplicationsInfo;
import br.com.pepper.specs.repositories.ApplicationsInfoRepository;

@Service
public class ApplicationsService {

    @Autowired
    private ComandoService comandoService;
    private ApplicationsInfoRepository applicationsInfoRepository;

    public ResponseEntity<Object> getApplicationInfo() throws IOException {
        var applicationsInfo = new ApplicationsInfo();
        applicationsInfo.setApplications(comandoService.comando("wmic product get name, version, installDate"));

        applicationsInfoRepository.save(applicationsInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(applicationsInfo);
    }

    
}