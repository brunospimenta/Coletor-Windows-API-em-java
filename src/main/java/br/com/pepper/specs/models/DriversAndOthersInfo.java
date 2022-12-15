package br.com.pepper.specs.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DriversAndOthersInfo {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> antiVirus;

    @ElementCollection
    private List<String> firewall;

    @ElementCollection
    private List<String> Proxy;

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getAntiVirus() {
        return antiVirus;
    }


    public void setAntiVirus(List<String> antiVirus) {
        this.antiVirus = antiVirus;
    }


    public List<String> getFirewall() {
        return firewall;
    }


    public void setFirewall(List<String> firewall) {
        this.firewall = firewall;
    }


    public List<String> getProxy() {
        return Proxy;
    }


    public void setProxy(List<String> proxy) {
        Proxy = proxy;
    }


    public DriversAndOthersInfo(){
        
    }

    @Override
    public String toString() {
        return "DriversAndOthersInfo [Proxy=" + Proxy + ", antiVirus=" + antiVirus + ", firewall=" + firewall + "]";
    }
}