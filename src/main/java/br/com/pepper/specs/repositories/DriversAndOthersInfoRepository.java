package br.com.pepper.specs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pepper.specs.models.DriversAndOthersInfo;

public interface DriversAndOthersInfoRepository extends JpaRepository<DriversAndOthersInfo, Long>{
    
}