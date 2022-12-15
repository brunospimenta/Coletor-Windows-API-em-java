package br.com.pepper.specs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pepper.specs.models.ApplicationsInfo;

public interface ApplicationsInfoRepository extends JpaRepository<ApplicationsInfo, Long> {
    
}