package br.senac.sp.appdesk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
