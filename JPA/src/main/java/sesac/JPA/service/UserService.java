package sesac.JPA.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.domain.ReplyEntity;
import sesac.JPA.domain.UserEntity;
import sesac.JPA.dto.UserDTO;
import sesac.JPA.repository.BoardRepository;
import sesac.JPA.repository.ReplyRepository;
import sesac.JPA.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private ReplyRepository replyRepository;

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
        List<BoardEntity> boardList = boardRepository.findByUserEntity_Id(userDTO.getId());
        UserEntity nullUser = new UserEntity();
        nullUser.setId("noName");
        for(int i=0; i<boardList.size(); i++){
            boardList.get(i).setUserEntity(nullUser);
        }
        List<ReplyEntity> replyList = replyRepository.findByUserEntity_Id(userDTO.getId());
        for(int j=0; j<replyList.size(); j++){
            replyList.get(j).setUserEntity(nullUser);
        }
        userRepository.deleteById(userDTO.getId());
    }
}
