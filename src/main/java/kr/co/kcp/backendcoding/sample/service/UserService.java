package kr.co.kcp.backendcoding.sample.service;

import kr.co.kcp.backendcoding.sample.User;
import kr.co.kcp.backendcoding.sample.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }
}
