package softuni.gira.web.controllers;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.gira.data.enums.ClassificationEnum;
import softuni.gira.data.enums.ProgressEnum;
import softuni.gira.mapping.TaskMapper;
import softuni.gira.service.ClassificationService;
import softuni.gira.service.TaskService;
import softuni.gira.service.UserService;
import softuni.gira.service.models.TaskServiceModel;

import softuni.gira.web.models.TaskBindingModel;

import javax.validation.Valid;
import java.security.Principal;


@Controller
@RequestMapping("/tasks")
public class TasksController {
    private final TaskService taskService;
    private final TaskMapper taskMapper;
    private final UserService userService;
    private final ClassificationService classificationService;

    public TasksController(TaskService taskService, TaskMapper taskMapper, UserService userService, ClassificationService classificationService) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
        this.userService = userService;
        this.classificationService = classificationService;
    }

    @ModelAttribute(name = "taskModel")
    public TaskBindingModel taskModel() {
        return new TaskBindingModel();
    }

    @GetMapping("/add")
    @PreAuthorize("isAuthenticated()")
    public ModelAndView addTask(ModelAndView modelAndView) {
        modelAndView.setViewName("add-task");
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addTaskConfirm(@Valid @ModelAttribute("taskModel") TaskBindingModel taskModel, Principal principal,
                                       BindingResult bindingResult,
                                       ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.addObject("taskModel", taskModel);
            modelAndView.setViewName("add-task");
            return modelAndView;
        }

        TaskServiceModel taskServiceModel = this.taskMapper.mapTaskBindingModelToTaskServiceModel(taskModel);
        taskServiceModel.setUser(this.userService.findByUsername(principal.getName()));
        taskServiceModel.setClassification(this.classificationService.findByName(taskModel.getClassification()));
        taskServiceModel.setProgress(ProgressEnum.OPEN);
        this.taskService.saveTask(taskServiceModel);
        modelAndView.setViewName("redirect:/home");
        return modelAndView;
    }

    @GetMapping("/progress/{id}")
    public String updateProgress(@PathVariable("id")String id) throws ChangeSetPersister.NotFoundException {
        this.taskService.updateProgress(id);
        return "redirect:/home";

    }
}
