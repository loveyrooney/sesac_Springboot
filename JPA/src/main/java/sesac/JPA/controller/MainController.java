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
import sesac.JPA.service.MainService;

import java.util.ArrayList;

@Controller
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping("/")
    public String home(Model model) {
        ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>) mainService.getBoardList();
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
    @PostMapping("/write")
    @ResponseBody
    public String boardCreate(@RequestBody BoardEntity boardEntity){
        System.out.println("c"+boardEntity.getName());
        mainService.createBoard(boardEntity);
        return "ok";
    }

}
