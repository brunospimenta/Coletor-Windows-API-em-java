package br.com.pepper.specs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pepper.specs.models.OperationalSystemInfo;

public interface OperationalSystemInfoRepository extends JpaRepository<OperationalSystemInfo,Long>{
    
}