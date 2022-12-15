package br.com.pepper.specs.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Timer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private long executionTime;

    public long getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(long executionTime) {
        this.executionTime = executionTime;
    }

    @Override
    public String toString() {
        return "Timer [executionTime=" + executionTime + "]";
    }



    
}