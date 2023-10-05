package kr.co.kcp.backendcoding.sample.domain.repository;

import jakarta.persistence.EntityManager;
import kr.co.kcp.backendcoding.sample.domain.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    private final EntityManager em;

    public List<UserRepo> findAll() {
        return em.createQuery("select s from UserRepo s ", UserRepo.class)
                .getResultList();
    }
}
