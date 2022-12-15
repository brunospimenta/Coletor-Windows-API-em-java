package br.com.pepper.specs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pepper.specs.models.Specifications;

@Repository
public interface SpecificationsRepository extends JpaRepository<Specifications, Long>{

    
    
}