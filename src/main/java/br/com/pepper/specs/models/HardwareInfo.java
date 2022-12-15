package br.com.pepper.specs.models;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HardwareInfo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    private List<String> manufacturerAndModel;

    @ElementCollection
    private List<String> mRam;

    @ElementCollection
    private List<String> processor;

    @ElementCollection
    private List<String> hardDisk;

    @ElementCollection
    private List<String> motherBoard;

    @ElementCollection
    private List<String> deviceId;

    @ElementCollection
    private List<String> productId;

    @ElementCollection
    private List<String> graphicCard;

    @ElementCollection
    private List<String> display;

    @ElementCollection
    private List<String> cams;

    
    public HardwareInfo(){
        
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public List<String> getManufacturerAndModel() {
        return manufacturerAndModel;
    }


    public void setManufacturerAndModel(List<String> manufacturerAndModel) {
        this.manufacturerAndModel = manufacturerAndModel;
    }


    public List<String> getmRam() {
        return mRam;
    }


    public void setmRam(List<String> mRam) {
        this.mRam = mRam;
    }


    public List<String> getProcessor() {
        return processor;
    }


    public void setProcessor(List<String> processor) {
        this.processor = processor;
    }


    public List<String> getHardDisk() {
        return hardDisk;
    }


    public void setHardDisk(List<String> hardDisk) {
        this.hardDisk = hardDisk;
    }


    public List<String> getMotherBoard() {
        return motherBoard;
    }


    public void setMotherBoard(List<String> motherBoard) {
        this.motherBoard = motherBoard;
    }


    public List<String> getDeviceId() {
        return deviceId;
    }


    public void setDeviceId(List<String> deviceId) {
        this.deviceId = deviceId;
    }


    public List<String> getProductId() {
        return productId;
    }


    public void setProductId(List<String> productId) {
        this.productId = productId;
    }


    public List<String> getGraphicCard() {
        return graphicCard;
    }


    public void setGraphicCard(List<String> graphicCard) {
        this.graphicCard = graphicCard;
    }


    public List<String> getDisplay() {
        return display;
    }


    public void setDisplay(List<String> display) {
        this.display = display;
    }


    public List<String> getCams() {
        return cams;
    }


    public void setCams(List<String> cams) {
        this.cams = cams;
    }  
    
    @Override
    public String toString() {
        return "HardwareInfo [cams=" + cams + ", deviceId=" + deviceId + ", display=" + display + ", graphicCard="
                + graphicCard + ", hardDisk=" + hardDisk + ", mRam=" + mRam + ", manufacturerAndModel="
                + manufacturerAndModel + ", motherBoard=" + motherBoard + ", processor=" + processor + ", productId="
                + productId + "]";
    }

}