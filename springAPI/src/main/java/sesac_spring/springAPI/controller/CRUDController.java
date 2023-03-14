package sesac_spring.springAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sesac_spring.springAPI.dto.UserDTO;
import sesac_spring.springAPI.service.MainService;

import java.util.ArrayList;

@Controller
public class CRUDController {

    @Autowired
    MainService mainService;
    @GetMapping("/user")
    public String home() {
        return "UserCreate";
    }
    @PostMapping("/user/signup")
    @ResponseBody
    public String signup(@RequestBody UserDTO newUser){
        mainService.addUser(newUser);
        return newUser.getNickname();
    }

    @GetMapping("/user/signIn")
    @ResponseBody
    public String signIn(@RequestParam(value = "userid") String userid, @RequestParam(value = "password") String password, @RequestParam(value="nickname", required = false) String nickname){
        System.out.println(userid);
        ArrayList<UserDTO> userList = (ArrayList<UserDTO>) mainService.getAUser(userid);
        System.out.println("userList" + userList.get(0).getUserid());

        //if(userid.equals(userList.get(0).getUserid())) return userList.get(0).getUserid();
        //else return "정확한 정보를 입력해 주세요";
        return "hi";
    }
}
