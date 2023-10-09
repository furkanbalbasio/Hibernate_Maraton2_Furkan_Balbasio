package org.example.controller;

import org.example.repository.entity.Computer;
import org.example.service.ComputerService;

import java.util.List;

public class ComputerController {
    ComputerService computerService;
    public ComputerController(){
        this.computerService = new ComputerService();
    }

    public void createPc(Long specid) {
        Computer computer= Computer.builder()
                .specid(specid)
                .build();
    }
    public List<Computer> findAll(){
        return computerService.findAll();
    }

}
