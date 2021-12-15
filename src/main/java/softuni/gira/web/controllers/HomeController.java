package softuni.gira.web.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.gira.service.TaskService;
import softuni.gira.service.models.TaskServiceModel;
import softuni.gira.web.models.TaskViewModel;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final TaskService taskService;

    public HomeController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ModelAndView getAll(ModelAndView modelAndView) {
        List<TaskViewModel> tasks = this.taskService.getAllTasks().stream()
                .map(t -> {
                    TaskViewModel taskViewModel = new TaskViewModel();
                    taskViewModel.setId(t.getId());
                    taskViewModel.setName(t.getName());
                    taskViewModel.setDescription(t.getDescription());
                    taskViewModel.setProgress(t.getProgress());
                    taskViewModel.setDueDate(t.getDueDate());
                    taskViewModel.setClassification(t.getClassification().getClassificationName());
                    taskViewModel.setAssignedTo(t.getUser().getUsername());
                    return taskViewModel;
                }).collect(Collectors.toList());
        modelAndView.addObject("tasks",tasks);
        modelAndView.setViewName("home");
        return modelAndView;
    }
}
