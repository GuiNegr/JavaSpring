package br.senac.sp.appdesk;

import jakarta.validation.Valid;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
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

    @Autowired
    OpenAiChatClient gpt;
    @GetMapping
    public String index(Model model, @AuthenticationPrincipal OAuth2User user) {
        var tasks = repository.findAll();
        model.addAttribute("tasks", tasks);
        model.addAttribute("user", user);
        return "task/index.html";
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

        if(task.getDescription() == null || task.getDescription().isBlank()){
            task.setDescription(gpt.call(
                    "CRIE UMA DESCRIÇÃO com até 200 caracteres  PARA ESSE JOGO COM O TITULO"+ task.getTitle()
            ));
        }
        repository.save(task);
        return "redirect:/task";
    }
}
