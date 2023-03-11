package sesac_spring.springAPI.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac_spring.springAPI.DTO.DTOController;
import sesac_spring.springAPI.VO.UserVO;

@Controller
public class MainController {

    @GetMapping("/")
    public  String main(){
        return "request";
    }

    //폼 안에 내용 적어서 이동
    @GetMapping("/get/response1")
    //@RequestParam("req input의 name밸류") String username(임의지정)) 이런식으로 가능
    public String getAPI1(@RequestParam(value = "name", required = true) String name, Model model){
        model.addAttribute("name",name);
        return "response";
    }

    @GetMapping("/get/response2")
    //@RequestParam("req input의 name밸류") String username(임의지정)) 이런식으로 가능
    public String getAPI2(@RequestParam(value = "name", required = false) String name, Model model){
        //required가 true인 값은 반드시 가야됨. 없을 시 처리 안됨. false의 경우, 값이 null로 처리는 됨)
        model.addAttribute("name",name);
        return "response";
    }

    //url에 req 내용을 라우터처럼 적어서 이동
    @GetMapping("/get/response3/{name}/{age}")
    //라우터에 있는 {name} 과 다른변수명일경우 @PathVariable String username 등으로 씀)
    public String getAPI3(@PathVariable String name, @PathVariable String age, Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "response";
    }

    @GetMapping({"/get/response4/{name}", "/get/response4/{name}/{age}"})
    //라우터에 있는 {name} 과 다른변수명일경우 @PathVariable String username 등으로 씀)
    public String getAPI4(@PathVariable String name, @PathVariable(value = "age", required = false) String age, Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "response";
    }

    @PostMapping("/post/response1")
    public String postAPI1(@RequestParam String name, Model model){
        model.addAttribute("name",name);
        return "response";
    }

    @PostMapping("/post/response2")
    public String postAPI2(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name",name);
        return "response";
    }

    @PostMapping("/post/response3")
    @ResponseBody //res.send로 만들겠다는 뜻, 동적폼전송시 사용
    public String postAPI3(@RequestParam(required = false) String name, Model model){
        return "이름은 : " + name;
    }

    @GetMapping("/introduce/{name}")
    public String getExam1(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "response";
    }

    @GetMapping("/introduce2")
    public String getExam2(@RequestParam String name, String age, Model model){
        model.addAttribute("name",name);
        model.addAttribute("age",age);
        return "response";
    }

    @PostMapping("/postexam")
    @ResponseBody
    public String postExam(@RequestParam String name, String gender, String birth, String interest){
        System.out.println(birth);
        String[] birthArr = birth.split(",");
        return "이름 : " + name + "<br>" + "성별 : " + gender + "<br>"+ "생년월일 : " + birthArr[0] + "-" + birthArr[1] + "-" + birthArr[2] + "<br>" + "관심사 : " + interest;
    }

    //DTO
    @GetMapping("/dto/response1")
    @ResponseBody
    public String getDTO1(DTOController dtoController){
        String msg = dtoController.getName() + " " + dtoController.getAge() + "!!";
        return msg;
    }

    @PostMapping("/dto/response2")
    @ResponseBody
    public String postDTO1(DTOController dtoController){
        String msg = dtoController.getName() + " " + dtoController.getAge() + "!!";
        return msg;
    }

    @PostMapping("/dto/response3")
    @ResponseBody
    public String postDTO3(@RequestBody DTOController dtoController){
        String msg = dtoController.getName() + " " + dtoController.getAge() + "!!";
        return msg;
    }

    //VO
    @GetMapping("/vo/response1")
    @ResponseBody
    public String getVO1(UserVO userVO){
        String msg = userVO.getName() + " " + userVO.getAge() + "!!";
        return msg;
    }

    @PostMapping("/vo/response2")
    @ResponseBody
    public String getVO2(UserVO userVO){
        String msg = userVO.getName() + " " + userVO.getAge() + "!!";
        return msg;
    }

    @PostMapping("/vo/response3")
    public String getVO3(@RequestBody UserVO userVO){
        String msg = userVO.getName() + " " + userVO.getAge() + "!!";
        return msg;
    }

    //axios - dto
    @GetMapping("/axios/response1")
    @ResponseBody
    public String axiosAPI1(@RequestParam(value = "name")String name, @RequestParam(value="age") String age){
        String msg = "이름 : " + name + "\n나이 : " + age;
        return msg;
    }

    @GetMapping("/axios/response2")
    @ResponseBody
    public String axiosAPI1(DTOController dtoController){
        String msg = "이름 : " + dtoController.getName() + "\n나이 : " + dtoController.getAge();
        return msg;
    }

    @PostMapping("/axios/response3")
    @ResponseBody
    public String axiosAPI3(@RequestParam(value = "name")String name,@RequestParam(value="age") String age){
        String msg = "이름 : " + name + "\n나이 : " + age;
        return msg;
    }

    @PostMapping("/axios/response4")
    @ResponseBody
    public String axiosAPI4(DTOController dtoController){
        String msg = "이름 : " + dtoController.getName() + "\n나이 : " + dtoController.getAge();
        return msg;
    }

    @PostMapping("/axios/response5")
    @ResponseBody
    public String axiosAPI5(@RequestBody DTOController dtoController){
        String msg = "이름 : " + dtoController.getName() + "\n나이 : " + dtoController.getAge();
        return msg;
    }

    //axios - vo
    @GetMapping("/axios/vo/response1")
    @ResponseBody
    public String axiosvoAPI1(@RequestParam(value = "name")String name, @RequestParam(value="age") String age){
        String msg = "이름 : " + name + "\n나이 : " + age;
        return msg;
    }

    @GetMapping("/axios/vo/response2")
    @ResponseBody
    public String axiosvoAPI2(UserVO userVO){
        String msg = "이름 : " + userVO.getName() + "\n나이 : " + userVO.getAge();
        return msg;
    }

    @PostMapping("/axios/vo/response3")
    @ResponseBody
    public String axiosvoAPI3(@RequestParam(value = "name")String name,@RequestParam(value="age") String age){
        String msg = "이름 : " + name + "\n나이 : " + age;
        return msg;
    }

    @PostMapping("/axios/vo/response4")
    @ResponseBody
    public String axiosvoAPI4(UserVO userVO){
        String msg = "이름 : " + userVO.getName() + "\n나이 : " + userVO.getAge();
        return msg;
    }

    @PostMapping("/axios/vo/response5")
    @ResponseBody
    public String axiosvoAPI5(@RequestBody UserVO userVO){
        String msg = "이름 : " + userVO.getName() + "\n나이 : " + userVO.getAge();
        return msg;
    }

    //동적 폼 axios 실습
    @PostMapping("/activeExam")
    @ResponseBody
    public String axiosExam(@RequestBody UserVO userVO){
        String msg = "이름: " + userVO.getName() + "\n성별 : " + userVO.getGender() + "\n생년월일 : " + userVO.getBirth() + "\n관심사 : " + userVO.getInterest();
        System.out.println(msg);
        String welcome = userVO.getName() + "회원가입 성공";
        return welcome;
    }
}
