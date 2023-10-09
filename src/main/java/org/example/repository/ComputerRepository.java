package org.example.repository;

import org.example.repository.entity.Computer;
import org.example.utility.MyFactoryRepository;

public class ComputerRepository extends MyFactoryRepository<Computer,Long> {
    public ComputerRepository() {
        super(new Computer());
    }
}
