package org.example.service;

import org.example.repository.ComputerSpecRepository;
import org.example.repository.UserRepository;
import org.example.repository.entity.ComputerSpec;
import org.example.repository.entity.User;

import java.util.List;
import java.util.Optional;

public class ComputerSpecService {
    ComputerSpecRepository computerSpecRepository;

    public ComputerSpecService(){
        this.computerSpecRepository = new ComputerSpecRepository();
    }

    public ComputerSpec save(ComputerSpec computerSpec){
        return computerSpecRepository.save(computerSpec);
    }


    public List<ComputerSpec> findAll(){
        return computerSpecRepository.findAll();
    }

    public Optional<ComputerSpec> findById(Long id){
        return computerSpecRepository.findById(id);
    }

    public List<ComputerSpec> saveAll(List<ComputerSpec> computerSpecList){
        return (List<ComputerSpec>) computerSpecRepository.saveAll(computerSpecList);
    }

    public void delete(ComputerSpec computerSpec){
        computerSpecRepository.delete(computerSpec);
    }

    public void deleteById(Long id){
        computerSpecRepository.deleteById(id);
    }

    public boolean existById(Long id){
        return computerSpecRepository.existById(id);
    }

    public List<ComputerSpec> findByEntity(ComputerSpec computerSpec){
        return computerSpecRepository.findByEntity(computerSpec);
    }

    public List<ComputerSpec> findByColumnNameAndValue(String columnName, String columnValue){
        return computerSpecRepository.findByColumnNameAndValue(columnName, columnValue);
    }
}
