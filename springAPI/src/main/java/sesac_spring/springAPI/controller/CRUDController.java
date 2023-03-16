package sesac_spring.springAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac_spring.springAPI.dto.UserDTO;
import sesac_spring.springAPI.service.MainService;

import java.util.ArrayList;

//@RestController : 이 컨트롤러 안에 있는 모든 함수에 @ResponsBody가 붙는다. 즉, 이 컨트롤러는 뷰를 로드하는 리턴이 아니라 무언가를 보내는 컨트롤러라는 뜻
//@RequestMapping("/user") : 이거 붙이면 아래에 나오는 경로는 전부 "/user/~~" 이렇게 됨. 아래 경로에는 ~~만 쓰면됨
@RequestMapping("/user")
@Controller
public class CRUDController {

    @Autowired
    MainService mainService;
    @GetMapping("")
    public String home() {
        return "UserCreate";
    }
    @PostMapping("/signup")
    @ResponseBody
    public String signup(@RequestBody UserDTO newUser){
        mainService.addUser(newUser);
        return newUser.getNickname();
    }

    @GetMapping("/signIn")
    @ResponseBody
    public String signIn(@RequestParam(value = "userid") String userid, @RequestParam(value = "password") String password, @RequestParam(value="nickname", required = false) String nickname){
        ArrayList<UserDTO> userList = (ArrayList<UserDTO>) mainService.getAUser(userid);
        if(userList.size() == 0) return "id not found";
        else if(password.equals(userList.get(0).getPassword())) return userList.get(0).getUserid();
        else return "pw error";
    }

    @PostMapping("/signin")
    @ResponseBody
    public boolean postLogin(@RequestBody UserDTO userDTO) {
        UserDTO user = mainService.getUser(userDTO);
        if(user == null) return false;
        else return true;
    }

    @PostMapping("/info")
    public String postInfo(UserDTO userDTO,Model model) {
        UserDTO user = mainService.getUser(userDTO);
        model.addAttribute("user",user);
        return "UserMypage";
    }

    //login 내방법
    //객체를 그대로 가져와서 보내고 싶었는데 그방법 몰라서 배열을 만들어가지고 보냈었음. 위에서 객체 그대로 보냄.
//    @GetMapping("/{userid}")
//    public String mypage(@PathVariable String userid, Model model){
//        ArrayList<UserDTO> userList = (ArrayList<UserDTO>) mainService.getAUser(userid);
//        String[] userArr = {userList.get(0).getUserid(),userList.get(0).getPassword(),userList.get(0).getNickname()};
//        model.addAttribute("user",userArr);
//        return "UserMypage";
//    }

    @PostMapping("/info/update")
    @ResponseBody
    public String userUpdate(@RequestBody UserDTO updateUser){
        mainService.updateUser(updateUser);
        return "";
    }

    //내방법
//    @PostMapping("/update")
//    @ResponseBody
//    public String userUpdate(@RequestBody UserDTO updateUser){
//        System.out.println("a " + updateUser.getNickname());
//        mainService.fixUser(updateUser);
//
//        return "hi";
//    }

    @PostMapping("/info/delete")
    @ResponseBody
    public String userDelete(@RequestBody UserDTO deleteUser) {
        mainService.removeUser(deleteUser);
        return "";
    }
}
