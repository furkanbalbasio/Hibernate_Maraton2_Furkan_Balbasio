package org.example.repository;

import org.example.repository.entity.User;
import org.example.utility.HibernateUtility;
import org.example.utility.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;


public class UserRepository extends MyFactoryRepository<User,Long> {
    CriteriaBuilder criteriaBuilder;
    EntityManager entityManager;
    public UserRepository() {
        super(new User());
        this.entityManager = HibernateUtility.getSessionFactory().createEntityManager();
        this.criteriaBuilder = entityManager.getCriteriaBuilder();
    }

    public Optional<User> loginVerify(String createdUsername) {
            User username =null;
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("username"),createdUsername));
            try {
                username = entityManager.createQuery(criteriaQuery).getSingleResult();
            } catch (Exception e){
                System.out.println(e.toString());
            }
            return Optional.ofNullable(username);
    }
}
