package sesac.JPA.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;
    private final PasswordEncoder passwordEncoder;

    public String checkUser(UserDTO userDTO) {
        Optional<UserEntity> getuser = userRepository.findById(userDTO.getId());
        if(getuser.isPresent()) {
            if(passwordEncoder.matches(userDTO.getPw(),getuser.get().getPw())) {
                return "verified";
            } else return "notVerified";
        } else {
            return "notPresent";
        }
    }

    public UserDTO getUser(String id) {
        Optional<UserEntity> getuser = userRepository.findById(id);
        if(getuser.isPresent()) {
            UserDTO user = new UserDTO();
            user.setId(getuser.get().getId());
            return user;
        } else {
            UserDTO nulluser = new UserDTO();
            return nulluser;
        }
    }

    public void createUser(UserDTO userDTO) {
        UserEntity user = new UserEntity();
        user.setId(userDTO.getId());
        user.setPw(passwordEncoder.encode(userDTO.getPw()));
        userRepository.save(user);
    }

    public String addUser(UserDTO userDTO){
        String check = checkUser(userDTO);
        if(check == "notPresent") {
            createUser(userDTO);
            return check;
        } else return "isPresent";
    }

    public Boolean updateUser(UserDTO userDTO){
        String check = checkUser(userDTO);
        if (check == "verified") return false;
        else {
            createUser(userDTO);
            return true;
        }
    }

    @Transactional
    public void deleteUser(UserDTO userDTO){
        Optional<UserEntity> getnulluser = userRepository.findById("nulluser");
        List<BoardEntity> boardList = boardRepository.findByUserEntity_Id(userDTO.getId());
        for(int i=0; i<boardList.size(); i++){
            boardList.get(i).setUserEntity(getnulluser.get());
            userRepository.save(getnulluser.get());
            boardRepository.save(boardList.get(i));
        }
        List<ReplyEntity> replyList = replyRepository.findByUserEntity_Id(userDTO.getId());
        for(int j=0; j<replyList.size(); j++){
            replyList.get(j).setUserEntity(getnulluser.get());
            userRepository.save(getnulluser.get());
            boardRepository.save(boardList.get(j));
        }
        userRepository.deleteById(userDTO.getId());
    }
}
