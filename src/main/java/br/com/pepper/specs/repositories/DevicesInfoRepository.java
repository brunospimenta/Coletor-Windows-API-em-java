package br.com.pepper.specs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pepper.specs.models.DevicesInfo;

public interface DevicesInfoRepository extends JpaRepository<DevicesInfo, Long> {

    
}