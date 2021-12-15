package softuni.gira.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.gira.service.TaskService;
import softuni.gira.service.models.TaskServiceModel;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ModelAndView getAll(ModelAndView modelAndView) {

        modelAndView.addObject("tasks", this.taskService.getAllTasks());
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
