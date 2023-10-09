package org.example.repository;

import org.example.repository.entity.Post;
import org.example.utility.MyFactoryRepository;

public class PostRepository extends MyFactoryRepository<Post,Long> {
    public PostRepository() {
        super(new Post());
    }
}
