package br.com.pepper.specs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pepper.specs.models.Timer;

public interface TimerRepository extends JpaRepository<Timer, Long>{


    
}