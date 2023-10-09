package org.example.controller;

import org.example.repository.ComputerSpecRepository;
import org.example.repository.entity.ComputerSpec;
import org.example.service.ComputerSpecService;

import java.util.List;

public class ComputerSpecController {
    ComputerSpecService computerSpecService;
    public ComputerSpecController(){
        this.computerSpecService = new ComputerSpecService();
    }

    public void createPcSpec(String ram,String ekranKarti,String islemci,String kapasite) {
        ComputerSpec computerSpec=ComputerSpec.builder()
                .ram(ram)
                .ekranKarti(ekranKarti)
                .islemci(islemci)
                .kapasite(kapasite)
                .build();
    }
    public List<ComputerSpec> findAll(){
        return computerSpecService.findAll();
    }
}
