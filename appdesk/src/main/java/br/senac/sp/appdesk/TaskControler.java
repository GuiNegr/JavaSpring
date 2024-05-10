package br.senac.sp.appdesk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("task")//o request indica qual será o caminho da requisição
public class TaskControler {

    @Autowired
    taskRepository repository;
    @GetMapping
    public String index(Model model){
        List<Task> tasks = repository.findAll();
        model.addAttribute("tasks",tasks);
        return "task/index";
    }

    // /task/delete/getId
    @PostMapping("/delete/{id}") //fazendo o caminho para fazer o acthion do jsp
    public String destroy(@PathVariable Long id){// anotação para indicar que e uma variavel vinda do jsp e trasnformando em bd
        System.out.println(id);
        repository.deleteById(id);
        return "redirect:/task";
    }

    @GetMapping("/new")
    public String form(){
        return "task/new";
    }
}
