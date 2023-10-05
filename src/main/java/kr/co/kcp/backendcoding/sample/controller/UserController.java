package kr.co.kcp.backendcoding.sample.controller;

import kr.co.kcp.backendcoding.sample.User;
import kr.co.kcp.backendcoding.sample.domain.UserRepo;
import kr.co.kcp.backendcoding.sample.service.UserRepoService;
import kr.co.kcp.backendcoding.sample.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class UserController {

    final private UserService userService;

    final private UserRepoService userRepoService;

    @GetMapping(value = "/user/all")
    public List<User> getAllUser() {
        return userService.selectAllUsers();
    }

    @GetMapping(value = "/user/find/all")
    public List<UserRepo> getFindAll() {
        return userRepoService.findAll();
    }
}
