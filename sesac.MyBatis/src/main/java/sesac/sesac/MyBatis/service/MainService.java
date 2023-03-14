package sesac.sesac.MyBatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesac.MyBatis.domain.User;
import sesac.sesac.MyBatis.dto.UserDTO;
import sesac.sesac.MyBatis.mapper.MainMapper;

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
            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setNickname(result.get(i).getNickname());
            user.setNo(i+1);

            users.add(user);
        }
        return users;

    }

    public void addUser(UserDTO user) {
        User user2 = new User();
        user2.setName(user.getName());
        user2.setNickname(user.getNickname());
        mainMapper.insertUser(user2); }

}
