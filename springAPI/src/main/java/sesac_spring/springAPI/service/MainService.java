package sesac_spring.springAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac_spring.springAPI.domain.User;
import sesac_spring.springAPI.dto.UserDTO;
import sesac_spring.springAPI.mapper.MainMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;

    public List<UserDTO> getUserList(){
    List<User> result = mainMapper.retrieveAll();
    List<UserDTO> users = new ArrayList<UserDTO>();

        for (int i = 0; i < result.size(); i++) {
        UserDTO user = new UserDTO();
        user.setUserid(result.get(i).getUserid());
        user.setPassword(result.get(i).getPassword());
        user.setNickname(result.get(i).getNickname());
        user.setNo(i+1);
        users.add(user);
        }
        return users;
    }

    public List<UserDTO> getAUser(String userid){
        List<User> result = mainMapper.retrieveOne(userid);
        System.out.println("result" + result.get(0).getUserid());
        List<UserDTO> AUser = new ArrayList<UserDTO>();
        UserDTO domainAUser = new UserDTO();

        domainAUser.setUserid(result.get(0).getUserid());
        domainAUser.setPassword(result.get(0).getPassword());
        AUser.add(domainAUser);
        return AUser;
    }

    public void addUser(UserDTO newUser) {
        User newDomainUser = new User();
        newDomainUser.setUserid(newUser.getUserid());
        newDomainUser.setPassword(newUser.getPassword());
        newDomainUser.setNickname(newUser.getNickname());
        mainMapper.insertUser(newDomainUser);
    }
}
