package sesac.sesac.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class Hellocontroller {
    @GetMapping("/hi") //app.get
    public String getHi(Model model){
        model.addAttribute("msg", "<b>Hello!</b>"); //res.render("hi",model);
        model.addAttribute("age",11);
        return "hi"; //res.render("hi")
    }

    @GetMapping("/people")
    public String getPeople(Model model){
        ArrayList<Person> personArr = new ArrayList<Person>();
        personArr.add(new Person("kim",10));
        personArr.add(new Person("lee",11));
        personArr.add(new Person("park",12));
        personArr.add(new Person("cho",13));

        model.addAttribute("people", personArr);
        return "people";
    }
}
