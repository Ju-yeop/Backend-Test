package kr.co.kcp.backendcoding.sample.service;

import kr.co.kcp.backendcoding.sample.domain.UserRepo;
import kr.co.kcp.backendcoding.sample.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserRepoService {

    private final UserRepository userRepository;

    public List<UserRepo> findAll() {
        return userRepository.findAll();
    }
}
