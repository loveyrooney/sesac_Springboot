package sesac.JPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.JPA.domain.UserEntity;
import sesac.JPA.dto.UserDTO;
import sesac.JPA.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(UserDTO userDTO){
        //System.out.println(userDTO.getId()+userDTO.getPw());
        UserEntity user = new UserEntity();
        user.setId(userDTO.getId());
        user.setPw(userDTO.getPw());
        userRepository.save(user);
    }

    public void updateUser(UserDTO userDTO){
        //save를 사용하려면 id가 int여야 하는데 나는 지금 string으로 쓰고있음. delete도 같은 상황..
    }

    @Transactional
    public void deleteUser(UserDTO userDTO){
        userRepository.deleteById(userDTO.getId());
    }
}
