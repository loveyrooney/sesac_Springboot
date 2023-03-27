package sesac.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.dto.BoardDTO;
import sesac.JPA.dto.UserDTO;
import sesac.JPA.service.BoardService;
import sesac.JPA.service.UserService;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    BoardService boardService;
    @Autowired
    UserService userService;


    @GetMapping("/")
    public String home(Model model) {
        ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) boardService.getBoardList();
        model.addAttribute("list",boardList);
        return "Main";
    }

    @GetMapping("/content")
    public String content(Model model) {
        //ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) mainService.getBoardList();
        //model.addAttribute("list",boardList);
        return "boardContent";
    }

    @GetMapping("/write")
    public String write(Model model) {
        //ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) mainService.getBoardList();
        //model.addAttribute("list",boardList);
        return "boardWrite";
    }

    @GetMapping("/loginHome")
    public String loginHome(Model model) {
        //ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) mainService.getBoardList();
        //model.addAttribute("list",boardList);
        return "login";
    }

    @GetMapping("/signupHome")
    public String signupHome(Model model) {
        //ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) mainService.getBoardList();
        //model.addAttribute("list",boardList);
        return "signup";
    }

    @GetMapping("/users")
    public String users(Model model) {
        //ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) mainService.getBoardList();
        //model.addAttribute("list",boardList);
        return "users";
    }

    @PostMapping("/signup")
    @ResponseBody
    public String signup(@RequestBody UserDTO userDTO){
        //System.out.println(userDTO.getId()+userDTO.getPw());
        userService.addUser(userDTO);
        return "회원 가입이 성공하였습니다.";
    }

    @PostMapping("/updateUser")
    @ResponseBody
    public String updateUser(@RequestBody UserDTO userDTO){
        //System.out.println(userDTO.getId()+userDTO.getPw());
        userService.updateUser(userDTO);
        return "회원정보가 수정되었습니다.";
    }

    @PostMapping("/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestBody UserDTO userDTO){
        //System.out.println(userDTO.getId()+userDTO.getPw());
        userService.deleteUser(userDTO);
        return "회원 탈퇴 되었습니다.";
    }
//    @PostMapping("/write")
//    @ResponseBody
//    public String boardCreate(@RequestBody BoardEntity boardEntity){
//        System.out.println("c"+boardEntity.getName());
//        mainService.createBoard(boardEntity);
//        return "ok";
//    }

}
