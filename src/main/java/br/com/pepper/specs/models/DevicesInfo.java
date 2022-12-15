package br.com.pepper.specs.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DevicesInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> audioDevice;

    @ElementCollection
    private List<String> networkAdapter;

    @ElementCollection
    private List<String> othersDevices;

    public DevicesInfo() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<String> getAudioDevice() {
        return audioDevice;
    }

    public void setAudioDevice(List<String> audioDevice) {
        this.audioDevice = audioDevice;
    }

    public List<String> getNetworkdAdapter() {
        return networkAdapter;
    }

    public void setNetworkdAdapter(List<String> list) {
        this.networkAdapter = list;
    }

    public List<String> getOthersDevices() {
        return othersDevices;
    }

    public void setOthersDevices(List<String> string) {
        this.othersDevices = string;
    }

    @Override
    public String toString() {
        return "DevicesInfo [audioDevice=" + audioDevice + ", networkdAdapter=" + networkAdapter
                + ", othersDevices=" + othersDevices + "]";
    }

}