package com.tcci.gt.mogesdoc.apibackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcci.gt.mogesdoc.apibackend.model.TipoPrefijo;

@Repository
public interface TipoPrefijoRepository extends JpaRepository<TipoPrefijo, Integer>{
    
}
