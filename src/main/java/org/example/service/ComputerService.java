package org.example.service;

import org.example.repository.ComputerRepository;
import org.example.repository.entity.Computer;

import java.util.List;
import java.util.Optional;

public class ComputerService {
    ComputerRepository computerRepository;

    public ComputerService(){
        this.computerRepository = new ComputerRepository();
    }

    public Computer save(Computer computer){
        return computerRepository.save(computer);
    }


    public List<Computer> findAll(){
        return computerRepository.findAll();
    }

    public Optional<Computer> findById(Long id){
        return computerRepository.findById(id);
    }

    public List<Computer> saveAll(List<Computer> computerList){
        return (List<Computer>) computerRepository.saveAll(computerList);
    }

    public void delete(Computer computer){
        computerRepository.delete(computer);
    }

    public void deleteById(Long id){
        computerRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return computerRepository.existById(id);
    }

    public List<Computer> findByEntity(Computer computer){
        return computerRepository.findByEntity(computer);
    }

    public List<Computer> findByColumnNameAndValue(String columnName, String columnValue){
        return computerRepository.findByColumnNameAndValue(columnName, columnValue);
    }
}
