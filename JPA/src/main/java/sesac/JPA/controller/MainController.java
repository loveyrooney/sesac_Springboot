package sesac.JPA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.JPA.domain.BoardEntity;
import sesac.JPA.dto.*;
import sesac.JPA.service.BoardService;
import sesac.JPA.service.ReplyService;
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

    @Autowired
    ReplyService replyService;


    @GetMapping("/")
    public String home(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        System.out.println("session " + sessionId);
        ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) boardService.getBoardList();
        model.addAttribute("list",boardList);
        //System.out.println(boardList.get(0).getBoardTitle());
        if(sessionId != null) {
            model.addAttribute("isLogin", true);
            model.addAttribute("userid",sessionId);
        } else model.addAttribute("isLogin", false);
        return "Main";
    }

    @GetMapping("/search")
    public String searchContent(@RequestParam String select, @RequestParam String search, Model model){
        ArrayList<BoardDTO> searchList = (ArrayList<BoardDTO>) boardService.getSearchList(select,search);
        model.addAttribute("list",searchList);
        return "search";
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
    public ResponseEntity<Boolean> login(@RequestBody UserDTO userDTO, HttpServletRequest request) {
        if(userDTO.getId().equals("") || userDTO.getPw().equals("")) return ResponseEntity.status(400).body(false);
        else {
            UserDTO getuserDTO = userService.checkUser(userDTO);
            if (getuserDTO.getPw() != null) {
                if (getuserDTO.getPw().equals(userDTO.getPw())) {
                    HttpSession session = request.getSession();
                    session.setAttribute("sessionId", getuserDTO.getId());
                    return ResponseEntity.status(201).body(true);
                } else return ResponseEntity.status(204).body(false);
            } else return ResponseEntity.status(404).body(false);
        }
    }

    @PostMapping("/logout")
    @ResponseBody
    public ResponseEntity<Boolean> logout(@RequestBody UserDTO userDTO, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        if(sessionId.equals(userDTO.getId())) {
            session.invalidate();
            return ResponseEntity.status(201).body(true);
        } else return ResponseEntity.status(404).body(false);
    }

    @GetMapping("/signupHome")
    public String signupHome(Model model) {
        return "signup";
    }

    @PostMapping("/createUser")
    @ResponseBody
    public ResponseEntity<String> signup(@RequestBody UserDTO userDTO){
        userService.addUser(userDTO);
        return ResponseEntity.status(201).body("회원 가입이 성공하였습니다.");
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
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDTO){
        //System.out.println(userDTO.getId()+userDTO.getPw());
        userService.updateUser(userDTO);
        return ResponseEntity.status(204).body("회원정보가 수정되었습니다.");
    }

    @PostMapping("/deleteUser")
    @ResponseBody
    public ResponseEntity<String> deleteUser(@RequestBody UserDTO userDTO, HttpServletRequest req){
        String userPw = userService.checkUser(userDTO).getPw();
        if(userPw.equals(userDTO.getPw())) {
            HttpSession session = req.getSession();
            session.invalidate();
            userService.deleteUser(userDTO);
            return ResponseEntity.status(204).body("회원 탈퇴 되었습니다.");
        } else return ResponseEntity.status(404).body("비밀번호가 틀렸습니다.");
    }

    @GetMapping("/content/{id}")
    public String content(@PathVariable int id, Model model, HttpServletRequest req) {
        BoardDTO targetBoard = boardService.getBoardInfo(id);
        ArrayList<ReplyDTO> replyList = (ArrayList<ReplyDTO>) replyService.getReplyList(id);
        HttpSession session = req.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        if(sessionId != null) model.addAttribute("userid",sessionId);
        else model.addAttribute("userid","noname");
        model.addAttribute("board",targetBoard);
        model.addAttribute("list",replyList);
        return "boardContent";
    }

    @GetMapping("/write")
    public String write(Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        if(sessionId != null) model.addAttribute("userid", sessionId);
        return "boardWrite";
    }
    @PostMapping("/createBoard")
    public String boardCreate(CreateBoardDTO createBoardDTO){
        System.out.println(createBoardDTO.getUserId()+" \n" + createBoardDTO.getBoardTitle()+" \n" + createBoardDTO.getBoardContent()+" \n" + createBoardDTO.getBoardDate());
        boardService.createBoard(createBoardDTO);
        return "redirect:/";
    }

    @GetMapping("/write/{id}")
    public String boardUpdateHome(@PathVariable int id, Model model, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String sessionId = (String)session.getAttribute("sessionId");
        if(sessionId != null){
            BoardDTO targetBoard = boardService.getBoardInfo(id);
            model.addAttribute("userid",sessionId);
            model.addAttribute("board",targetBoard);
        }
        else model.addAttribute("userid",false);
        return "boardWrite";
    }

    @PatchMapping("/updateBoard")
    @ResponseBody
    public ResponseEntity<String> boardUpdate(@RequestBody BoardDTO boardDTO){
        System.out.println(boardDTO.getBoardId()+" \n" + boardDTO.getUserId()+" \n" + boardDTO.getBoardTitle()+" \n" + boardDTO.getBoardContent()+" \n" + boardDTO.getBoardDate());
        boardService.updateBoard(boardDTO);
        return ResponseEntity.status(201).body("글이 수정되었습니다.");
    }

    @PostMapping("/deleteBoard")
    @ResponseBody
    public ResponseEntity<String> boardDelete(@RequestBody DeleteBoardDTO boardDTO){
        System.out.println("delete"+boardDTO.getBoardId()+" \n" + boardDTO.getUserId()+" \n" + boardDTO.getPw());
        UserDTO getuser = userService.getUser(boardDTO.getUserId());
        String userPw = userService.checkUser(getuser).getPw();
        if(userPw.equals(boardDTO.getPw())) {
            boardService.deleteBoard(boardDTO.getBoardId());
            return ResponseEntity.status(201).body("글이 삭제되었습니다.");
        } else return ResponseEntity.status(404).body("비밀번호가 틀렸습니다.");
    }

    @PostMapping("/createReply")
    @ResponseBody
    public ResponseEntity<Object> replyCreate(@RequestBody ReplyDTO replyDTO){
        replyService.createReply(replyDTO);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/deleteReply")
    public ResponseEntity<String> replyDelete(@RequestBody ReplyDTO replyDTO){
        replyService.deleteReply(replyDTO.getReplyId());
        return ResponseEntity.status(204).build();
    }
}
