package org.example.repository;

import org.example.repository.entity.Like;
import org.example.utility.MyFactoryRepository;

public class LikeRepository extends MyFactoryRepository<Like,Long> {
    public LikeRepository() {
        super(new Like());
    }
}
