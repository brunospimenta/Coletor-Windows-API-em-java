package br.com.pepper.specs.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OperationalSystemInfo {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> Hostname;

    @ElementCollection
    private List<String> OS;

    @ElementCollection
    private List<String> status;

    @ElementCollection
    private List<String> installDate;
    
    private LocalDate firstSync;

    @ElementCollection
    private List<String> lastUsername;

    @ElementCollection
    private List<String> domain;

    @ElementCollection
    private List<String> ip;

    @ElementCollection
    private List<String> upTime;

    public OperationalSystemInfo(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getHostname() {
        return Hostname;
    }

    public void setHostname(List<String> hostname) {
        Hostname = hostname;
    }

    public List<String> getOS() {
        return OS;
    }

    public void setOS(List<String> oS) {
        OS = oS;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public List<String> getInstallDate() {
        return installDate;
    }

    public void setInstallDate(List<String> installDate) {
        this.installDate = installDate;
    }

    public LocalDate getFirstSync() {
        return firstSync;
    }

    public void setFirstSync(LocalDate localDate) {
        this.firstSync = localDate;
    }

    public List<String> getLastUsername() {
        return lastUsername;
    }

    public void setLastUsername(List<String> lastUsername) {
        this.lastUsername = lastUsername;
    }

    public List<String> getDomain() {
        return domain;
    }

    public void setDomain(List<String> domain) {
        this.domain = domain;
    }

    public List<String> getIp() {
        return ip;
    }

    public void setIp(List<String> ip) {
        this.ip = ip;
    }



    public List<String> getUpTime() {
        return upTime;
    }

    public void setUpTime(List<String> upTime) {
        this.upTime = upTime;
    }

    @Override
    public String toString() {
        return "OperationalSystemInfo [Hostname=" + Hostname + ", OS=" + OS + ", Uptime=" + installDate + ", UpTime=" + upTime + ", domain="
                + domain + ", firstSync=" + firstSync + ", ip=" + ip + ", lastUsername=" + lastUsername
                + ", status=" + status + "]";
    }
}