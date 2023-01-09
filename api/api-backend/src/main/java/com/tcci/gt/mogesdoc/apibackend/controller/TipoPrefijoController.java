package com.tcci.gt.mogesdoc.apibackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcci.gt.mogesdoc.apibackend.model.TipoPrefijo;
import com.tcci.gt.mogesdoc.apibackend.repository.TipoPrefijoRepository;

import jakarta.transaction.Transactional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1.0/tiposPrefijo")
public class TipoPrefijoController {
    
    @Autowired
    private TipoPrefijoRepository tipoPrefijoRepository;

    @GetMapping("/")
    public List<TipoPrefijo> retrieveAllTipoPrefijo(){
        return tipoPrefijoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoPrefijo> retrieveTipoPrefijo(@PathVariable("id")int id){
        Optional<TipoPrefijo> tipoPrefijoData = tipoPrefijoRepository.findById(id);

        if(tipoPrefijoData.isPresent()){
            return new ResponseEntity<>(tipoPrefijoData.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Transactional
    @PostMapping("/")
    public ResponseEntity<TipoPrefijo> createTipoPrefijo(@RequestBody TipoPrefijo tipoPrefijo){
        try{
            TipoPrefijo _tipoPrefijo = tipoPrefijoRepository.save(tipoPrefijo);
            return new ResponseEntity<>(_tipoPrefijo, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
