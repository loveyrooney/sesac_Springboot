package sesac.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.dto.BoardDTO;
import sesac.JPA.dto.UserDTO;
import sesac.JPA.service.BoardService;
import sesac.JPA.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    BoardService boardService;
    @Autowired
    UserService userService;


    @GetMapping("/")
    public String home(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        System.out.println("session" + sessionId);
        ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) boardService.getBoardList();
        model.addAttribute("list",boardList);
        if(sessionId != null) {
            model.addAttribute("isLogin", true);
            model.addAttribute("userid",sessionId);
        } else model.addAttribute("isLogin", false);
        return "Main";
    }

    @GetMapping("/loginHome")
    public String loginHome(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        if(sessionId != null) {
            model.addAttribute("isLogin", true);
            model.addAttribute("userid",sessionId);
        } else model.addAttribute("isLogin", false);
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public Boolean login(@RequestBody UserDTO userDTO, HttpServletRequest request) {
        UserDTO getuserDTO = userService.checkUser(userDTO);
        if(getuserDTO.getPw() != null) {
            if(getuserDTO.getPw().equals(userDTO.getPw())) {
                HttpSession session = request.getSession();
                session.setAttribute("sessionId", getuserDTO.getId());
//            String sessionid = (String)session.getAttribute("sessionId");
//            System.out.println("gethere"+ sessionid);
                return true;
            }
            else return false;
        }
        else return false;
    }

    @PostMapping("/logout")
    @ResponseBody
    public Boolean logout(@RequestBody UserDTO userDTO, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        if(sessionId.equals(userDTO.getId())) {
            session.invalidate();
            return true;
        } else return false;
    }

    @GetMapping("/signupHome")
    public String signupHome(Model model) {
        //ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) mainService.getBoardList();
        //model.addAttribute("list",boardList);
        return "signup";
    }

    @PostMapping("/createUser")
    @ResponseBody
    public String signup(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        return "회원 가입이 성공하였습니다.";
    }

    @GetMapping("/users")
    public String users(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        UserDTO getuser = userService.getUser(sessionId);
        model.addAttribute("userid",sessionId);
        model.addAttribute("userpw",getuser.getPw());
        return "users";
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
    public String deleteUser(@RequestBody UserDTO userDTO, HttpServletRequest req){
        HttpSession session = req.getSession();
        session.invalidate();
        userService.deleteUser(userDTO);
        return "회원 탈퇴 되었습니다.";
    }

    @GetMapping("/write")
    public String write(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        if(sessionId != null) model.addAttribute("userid",sessionId);
        return "boardWrite";
    }
    @PostMapping("/createBoard")
    public String boardCreate(BoardDTO boardDTO){
        System.out.println(boardDTO.getBoardId()+boardDTO.getUserId()+boardDTO.getBoardTitle()+boardDTO.getBoardContent()+boardDTO.getBoardDate());
        boardService.createBoard(boardDTO);
        return "Main";
    }

    @GetMapping("/content/{id}")
    public String content(@PathVariable String id, Model model, HttpServletRequest req) {
        BoardDTO targetBoard = boardService.getBoardInfo(id);
        HttpSession session = req.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        if(sessionId != null) model.addAttribute("userid",sessionId);
        else model.addAttribute("userid","noname");
        model.addAttribute("board",targetBoard);
        return "boardContent";
    }










}
