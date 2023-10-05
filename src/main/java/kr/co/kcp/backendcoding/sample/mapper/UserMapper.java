package kr.co.kcp.backendcoding.sample.mapper;

import kr.co.kcp.backendcoding.sample.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectAllUsers();
}
