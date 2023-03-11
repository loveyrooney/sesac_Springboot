package sesac_spring.springAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sesac_spring.springAPI.DTO.UserDTO;

@Controller
public class CRUDController {
    @GetMapping("/user")
    public String home() {
        return "User create";
    }
    @PostMapping("/user/signup")
    @ResponseBody
    public String signup(@RequestBody UserDTO userDTO){
        return userDTO.getNickname();
    }

//    @GetMapping("/user/signin")
//    @ResponseBody
//    public String signin(@RequestParam(value = "userid")String userid, @RequestParam(value="password") String password){
//        if(userid != UserDTO.getUserid())
//        String msg = "이름 : " + name + "\n나이 : " + age;
//        return msg;
//    }
}
