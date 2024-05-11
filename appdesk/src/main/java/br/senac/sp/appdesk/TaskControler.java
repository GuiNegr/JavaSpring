package br.senac.sp.appdesk;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String form(Task task){
        return "task/new";
    }

    @PostMapping
    public String create(@Valid Task task,BindingResult result ){
        if(result.hasErrors()) return "task/new";
        repository.save(task);
        return "redirect:/task";
    }
}
