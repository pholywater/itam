package hmm.itam.service;

import hmm.itam.mapper.UserMapper;
import hmm.itam.vo.UserVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    /*회원 정보 리스트*/
    public List<UserVo> getUserList() {

        return userMapper.getUserList();
    }

    /*메인 로그인 화면 처리*/
    public Long login(String hmm_id, String password) {
        UserVo userVo = userMapper.getUserByHmm_id(hmm_id);
        if (userVo.getPassword().equals(password)){
            return userVo.getIdx();
/*
        System.out.println("service.check.hmm_id :"+ hmm_id);
        System.out.println("service.check.password :"+ password);
        System.out.println("service.check.vo.password :"+ userVo.getPassword());
        System.out.println("service.check.getIdx :"+ userVo.getIdx());
*/
        }
        return null;
    }

    /*회원 정보 등록*/
    public void signup(UserVo userVo){

        userMapper.insertUser(userVo);
    }

    /*홈 화면 정보 확인*/
    public UserVo getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    /*회원 정보 수정*/
    public void modifyInfo(UserVo userVo) {
        userMapper.updateUser(userVo);
    }

    /*탈퇴하기*/
    public void withdraw(Long id) {
        userMapper.deleteUser(id);
    }
}
