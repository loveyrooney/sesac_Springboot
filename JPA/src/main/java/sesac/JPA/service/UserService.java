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

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ReplyRepository replyRepository;

    @Autowired
    public UserService(UserRepository userRepository, BoardRepository boardRepository,ReplyRepository replyRepository) {
        this.userRepository = userRepository;
        this.boardRepository = boardRepository;
        this.replyRepository = replyRepository;
    }

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
        UserEntity user = new UserEntity();
        user.setId(userDTO.getId());
        user.setPw(userDTO.getPw());
        userRepository.save(user);
    }

    public void updateUser(UserDTO userDTO){
        UserDTO getuser = getUser(userDTO.getId());
        getuser.setPw(userDTO.getPw());
        addUser(userDTO);
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
