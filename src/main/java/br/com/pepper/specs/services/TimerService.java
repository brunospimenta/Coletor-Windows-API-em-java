package br.com.pepper.specs.services;

import org.springframework.stereotype.Service;

import br.com.pepper.specs.models.Timer;

@Service
public class TimerService {
        
    public Long tempoInicio(){
        long startTime = System.nanoTime();
        
        return startTime;       
    }

    public Long tempoTermino(){
        Long endTime = System.nanoTime();

        return endTime;
    }


    public Timer tempoDeExecucao(Long inicio, Long termino){

        Timer timer = new Timer();
        Long timeElapsed = termino - inicio;

        Long tempoEmSecs = (timeElapsed / 1000000000);

        timer.setExecutionTime(tempoEmSecs);
        return timer;
    }
}