package br.com.pepper.specs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pepper.specs.models.HardwareInfo;

public interface HardwareInfoRepository extends JpaRepository<HardwareInfo,Long>{
    
}