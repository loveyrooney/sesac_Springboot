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

    //내 방법 read
    public List<UserDTO> getAUser(String userid){
        List<User> result = mainMapper.retrieveOne(userid);
        //System.out.println("result1" + result);
        List<UserDTO> AUser = new ArrayList<UserDTO>();
        if(result.size() != 0) {
            System.out.println("result " + result.get(0).getUserid());
            UserDTO domainAUser = new UserDTO();
            domainAUser.setUserid(result.get(0).getUserid());
            domainAUser.setPassword(result.get(0).getPassword());
            AUser.add(domainAUser);
        }
        return AUser;
    }

    public void addUser(UserDTO newUser) {
        User newDomainUser = new User();
        newDomainUser.setUserid(newUser.getUserid());
        newDomainUser.setPassword(newUser.getPassword());
        newDomainUser.setNickname(newUser.getNickname());
        mainMapper.insertUser(newDomainUser);
    }

    //login
    public UserDTO getUser(UserDTO userDTO) {
       User user = mainMapper.getUser(userDTO.getUserid(),userDTO.getPassword());
       if(user == null) return null;
       UserDTO info = new UserDTO();
       info.setUserid(user.getUserid());
       info.setPassword(user.getPassword());
       info.setNickname(user.getNickname());
       return info;
    }

    //update
    public void updateUser(UserDTO updateUser) {
        User user = new User();
        user.setUserid(updateUser.getUserid());
        user.setPassword(updateUser.getPassword());
        user.setNickname(updateUser.getNickname());
        mainMapper.updateUser(user);
    }

    //내가 시도하려고 했던 update
    public void fixUser(UserDTO updateUser) {
        List<User> result = mainMapper.retrieveOne(updateUser.getUserid());
        result.get(0).setNickname(updateUser.getNickname());
        result.get(0).setPassword(updateUser.getPassword());
        mainMapper.updateUser(result.get(0));
        System.out.println("up "+ result);
    }

    public void removeUser(UserDTO deleteUser) {
        mainMapper.deleteUser(deleteUser.getUserid());
    }
}

//리스트로 부르는 것, 객체 자체를 가져오는것, dto에서 바로 보내거나 or 도메인에 담아서 보내거나 이 차이의 필요를 각각 생각해볼것
//노드의 경우 컨트롤러에서 바로 db로 접근을 하고 오리지널 데이터를 가져와서 쓰는 방식인데, 자바는 객체지향이라 객체를 통해서 가져와 쓴다.
//이 차이와 각각의 장단점, 각각의 필요에 대해서 생각해 볼것.
//얼른 떠오르는 것은 객체를 통해 가져왔을때는 활용방식의 선택지가 넓어져서 케이스마다 어떤 방식 쓸지 적용하는데 원활한것
//그러나 복잡해지기 때문에 용량도 커지고 속도 느릴거 같음
//노드는 다이렉트로 가져오기 때문에 속도 빠르고 코드 간결한거 좋은데 방식이 원루트기때문에 어떤 다양함에 대응할수 잇을지 모르겟음
