package sesac_spring.springAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        ArrayList<UserDTO> userList = (ArrayList<UserDTO>) mainService.getAUser(userid);
        if(userList.size() == 0) return "id not found";
        else if(password.equals(userList.get(0).getPassword())) return userList.get(0).getUserid();
        else return "pw error";
    }

    @GetMapping("/user/{userid}")
    public String mypage(@PathVariable String userid, Model model){
        ArrayList<UserDTO> userList = (ArrayList<UserDTO>) mainService.getAUser(userid);
        String[] userArr = {userList.get(0).getUserid(),userList.get(0).getPassword(),userList.get(0).getNickname()};
        model.addAttribute("user",userArr);
        return "UserMypage";
    }

    @PostMapping("/user/update")
    @ResponseBody
    public String userUpdate(@RequestBody UserDTO updateUser){
        System.out.println("a " + updateUser.getNickname());
        mainService.fixUser(updateUser);

        return "hi";
    }

    @PostMapping("/user/delete")
    @ResponseBody
    public String userDelete(@RequestBody UserDTO deleteUser) {
        mainService.removeUser(deleteUser);
        return "hi";
    }
}
