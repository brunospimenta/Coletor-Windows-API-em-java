package br.com.pepper.specs.services.InfoService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.pepper.specs.models.ApplicationsInfo;
import br.com.pepper.specs.models.DevicesInfo;
import br.com.pepper.specs.models.DriversAndOthersInfo;
import br.com.pepper.specs.models.HardwareInfo;
import br.com.pepper.specs.models.OperationalSystemInfo;
import br.com.pepper.specs.models.Specifications;
import br.com.pepper.specs.repositories.ApplicationsInfoRepository;
import br.com.pepper.specs.repositories.DevicesInfoRepository;
import br.com.pepper.specs.repositories.DriversAndOthersInfoRepository;
import br.com.pepper.specs.repositories.HardwareInfoRepository;
import br.com.pepper.specs.repositories.OperationalSystemInfoRepository;
import br.com.pepper.specs.repositories.SpecificationsRepository;
import br.com.pepper.specs.services.TimerService;

@Service
public class SpecificationService {

    @Autowired
    private ComandoService comandoService;

    @Autowired
    private SpecificationsRepository specificationsRepository;

    @Autowired
    private DevicesInfoRepository devicesInfoRepository;

    @Autowired
    private DriversAndOthersInfoRepository driversAndOthersInfoRepository;

    @Autowired
    private ApplicationsInfoRepository applicationsInfoRepository;

    @Autowired
    private HardwareInfoRepository hardwareInfoRepository;

    @Autowired
    private OperationalSystemInfoRepository operationalSystemInfoRepository;

    @Autowired TimerService timerService;   

    public List<Specifications> findAll() {
        return specificationsRepository.findAll();
    }

    /*

    public DevicesInfo devicesFindById(Long id) {
        return devicesInfoRepository.getReferenceById(id);
    }

    public DriversAndOthersInfo driversAndOtherFindById(Long id) {
        return driversAndOthersInfoRepository.getReferenceById(id);
    }

    public ApplicationsInfo applicationFindById(Long id) {
        return applicationsInfoRepository.getReferenceById(id);
    }

    public HardwareInfo hardwareFindById(Long id) {
        return hardwareInfoRepository.getReferenceById(id);
    }

    public OperationalSystemInfo OSFindById(Long id) {
        return operationalSystemInfoRepository.getReferenceById(id);
    }
    */
    public ResponseEntity<Object> getAllSpecification() throws IOException {

        Long inicio = timerService.tempoInicio();
        // DevicesInfo
        var devicesInfo = new DevicesInfo();

        devicesInfo.setAudioDevice(comandoService.comando("wmic path win32_SoundDevice get name"));
        devicesInfo.setNetworkdAdapter(comandoService.comando("wmic nic get AdapterType, Name, Installed"));
        devicesInfo.setOthersDevices(comandoService.comando("pnputil /enum-devices | findstr USB"));

        devicesInfoRepository.save(devicesInfo);

        // DriversAndOthersInfo

        var driversAndOthersInfo = new DriversAndOthersInfo();
        driversAndOthersInfo.setAntiVirus(comandoService.comando(
                "wmic /Node:localhost/Namespace:\\\\root\\SecurityCenter2 Path AntiVirusProduct Get displayName"));
        driversAndOthersInfo.setFirewall(comandoService.comando("netsh advfirewall show allprofiles"));
        driversAndOthersInfo.setProxy(comandoService.comando("netsh winhttp show proxy"));

        driversAndOthersInfoRepository.save(driversAndOthersInfo);

        // ApplicationsInfo

        var applicationsInfo = new ApplicationsInfo();
        applicationsInfo.setApplications(comandoService.comando("wmic product get name, version, installDate"));
        applicationsInfoRepository.save(applicationsInfo);

        // HardwareInfo

        var hardwareInfo = new HardwareInfo();
        hardwareInfo.setCams(comandoService.comando("wmic os get serial number"));
        hardwareInfo.setDeviceId(comandoService.comando("wmic os get serialnumber"));
        hardwareInfo.setDisplay(comandoService.comando("wmic desktopmonitor get Name,MonitorType,MonitorManufacturer"));
        hardwareInfo.setGraphicCard(comandoService.comando("wmic path win32_VideoController get name"));
        hardwareInfo.setHardDisk(comandoService.comando("wmic diskdrive get model, size"));
        hardwareInfo.setManufacturerAndModel(comandoService.comando("wmic computersystem get model, manufacturer"));
        hardwareInfo.setMotherBoard(comandoService.comando("wmic baseboard get product, Manufacturer"));
        hardwareInfo.setProcessor(comandoService.comando("wmic cpu get name"));
        hardwareInfo.setProductId(comandoService.comando("systeminfo | findstr \"Product ID\""));
        hardwareInfo.setmRam(comandoService.comando("systeminfo | find \"Total Physical Memory\""));        

        hardwareInfoRepository.save(hardwareInfo);

        // OpetarionalSystemInfo
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

        Specifications specs = new Specifications(/*
                                                   * devicesInfo, driversAndOthersInfo,applicationsInfo, hardwareInfo,
                                                   * operationalSystemInfo
                                                   */);

        specs.setHardwareInfo(hardwareInfo);
        specs.setOperationalSystemInfo(operationalSystemInfo);
        specs.setDevicesInfo(devicesInfo);
        specs.setDriversAndOthersInfo(driversAndOthersInfo);
        specs.setApplicationsInfo(applicationsInfo);
        Long termino = timerService.tempoTermino();
        specs.setExecutionTimerInSecs(timerService.tempoDeExecucao(inicio, termino));

        /*
         * Specifications specs = new
         * Specifications(devicesFindById(operationalSystemInfo.getId()),
         * driversAndOtherFindById(driversAndOthersInfo.getId()),
         * applicationFindById(applicationsInfo.getId()),
         * hardwareFindById(hardwareInfo.getId()),
         * OSFindById(operationalSystemInfo.getId())
         * );
         */        

        specificationsRepository.save(specs);
        return ResponseEntity.status(HttpStatus.CREATED).body(specs);
    }       
}