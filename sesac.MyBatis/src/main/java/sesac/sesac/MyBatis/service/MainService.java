package sesac.sesac.MyBatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesac.MyBatis.domain.User;
import sesac.sesac.MyBatis.domain.UserEntity;
import sesac.sesac.MyBatis.dto.UserDTO;
import sesac.sesac.MyBatis.mapper.MainMapper;
import sesac.sesac.MyBatis.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MainService {

    @Autowired
    private MainMapper mainMapper;
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getUserList(){
        List<UserEntity> result = userRepository.findAll();
        //List<User> result = mainMapper.retrieveAll();
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
        public void addUser(UserEntity user) { userRepository.save(user);}

//    public void addUser(UserDTO user) {
//        User user2 = new User();
//        user2.setName(user.getName());
//        user2.setNickname(user.getNickname());
//        mainMapper.insertUser(user2); }

        public ArrayList<UserDTO> getUserName(String name) {
            Optional<UserEntity> user = userRepository.findByName(name);
            ArrayList<UserDTO> userList = new ArrayList<>();

            if(user.isPresent()) {
                UserDTO dto = new UserDTO();
                dto.setId(user.get().getId());
                dto.setNo(0);
                dto.setName(user.get().getName());
                dto.setNickname(user.get().getNickname());
                userList.add(dto);
            }
            return userList;
        }

}
