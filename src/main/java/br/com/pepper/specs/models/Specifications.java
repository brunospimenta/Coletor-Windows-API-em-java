package br.com.pepper.specs.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Specifications {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    

    @OneToOne(cascade = {CascadeType.ALL})
    private Timer executionTimerInSecs;    

    @OneToOne
    private HardwareInfo hardwareInfo;

    @OneToOne
    private OperationalSystemInfo operationalSystemInfo;

    @OneToOne
    private DevicesInfo devicesInfo;

    @OneToOne
    private DriversAndOthersInfo driversAndOthersInfo;

    @OneToOne
    private ApplicationsInfo applicationsInfo;

    public Specifications(){

    }

    public Specifications(
    DevicesInfo devicesInfo, DriversAndOthersInfo driversAndOthersInfo,
     ApplicationsInfo applicationsInfo, HardwareInfo hardwareInfo,
     OperationalSystemInfo operationalSystemInfo){

    }

    public ApplicationsInfo getApplicationsInfo() {
        return applicationsInfo;
    }

    public void setApplicationsInfo(ApplicationsInfo applicationsInfo) {
        this.applicationsInfo = applicationsInfo;
    }

    public DevicesInfo getDevicesInfo() {
        return devicesInfo;
    }

    public void setDevicesInfo(DevicesInfo devicesInfo) {
        this.devicesInfo = devicesInfo;
    }

    public DriversAndOthersInfo getDriversAndOthersInfo() {
        return driversAndOthersInfo;
    }

    public void setDriversAndOthersInfo(DriversAndOthersInfo driversAndOthersInfo) {
        this.driversAndOthersInfo = driversAndOthersInfo;
    }

    public HardwareInfo getHardwareInfo() {
        return hardwareInfo;
    }

    public void setHardwareInfo(HardwareInfo hardwareInfo) {
        this.hardwareInfo = hardwareInfo;
    }

    public OperationalSystemInfo getOperationalSystemInfo() {
        return operationalSystemInfo;
    }

    public void setOperationalSystemInfo(OperationalSystemInfo operationalSystemInfo) {
        this.operationalSystemInfo = operationalSystemInfo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timer getExecutionTimerInSecs() {
        return executionTimerInSecs;
    }

    public void setExecutionTimerInSecs(Timer executionTimer) {
        this.executionTimerInSecs = executionTimer;
    }
  

    @Override
    public String toString() {
        return "ExecutionTimer=" + executionTimerInSecs + "Specifications [devicesInfo=" + devicesInfo + ", applicationsInfo=" + applicationsInfo   
                + ", hardwareInfo=" + hardwareInfo + ", operationalSystemInfo=" + operationalSystemInfo +  ", driversAndOthersInfo=" + driversAndOthersInfo + "]";
    }
    
}