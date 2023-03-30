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

    public UserDTO checkUser(UserDTO userDTO) {
        Optional<UserEntity> getuser = userRepository.findById(userDTO.getId());
        if(getuser.isPresent()) {
            UserDTO getuserDTO = new UserDTO();
            getuserDTO.setId(getuser.get().getId());
            getuserDTO.setPw(getuser.get().getPw());
            return getuserDTO;
        } else {
            UserDTO nulluser = new UserDTO();
            return nulluser;
        }
    }

    public UserDTO getUser(String id) {
        Optional<UserEntity> getuser = userRepository.findById(id);
        if(getuser != null) {
            UserDTO user = new UserDTO();
            user.setId(getuser.get().getId());
            user.setPw(getuser.get().getPw());
            return user;
        } else {
            UserDTO nulluser = new UserDTO();
            return nulluser;
        }
    }

    public void addUser(UserDTO userDTO){
        //System.out.println(userDTO.getId()+userDTO.getPw());
        UserEntity user = new UserEntity();
        user.setId(userDTO.getId());
        user.setPw(userDTO.getPw());
        userRepository.save(user);
    }

    public void updateUser(UserDTO userDTO){
        Optional<UserEntity> getuser = userRepository.findById(userDTO.getId());
        getuser.get().setPw(userDTO.getPw());
        userRepository.save(getuser.get());
    }

    @Transactional
    public void deleteUser(UserDTO userDTO){
        userRepository.deleteById(userDTO.getId());
    }
}
