package org.example.repository;

import org.example.repository.entity.ComputerSpec;
import org.example.utility.MyFactoryRepository;

public class ComputerSpecRepository extends MyFactoryRepository<ComputerSpec,Long> {
    public ComputerSpecRepository() {
        super(new ComputerSpec());
    }
}
