package softuni.gira.web.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import softuni.gira.mapping.UserMapper;
import softuni.gira.service.UserService;
import softuni.gira.service.models.UserServiceModel;
import softuni.gira.web.models.UserRegisterBindingModel;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserMapper userMapper;
    private final UserService userService;

    public UsersController(UserMapper userMapper, UserService userService) {
        this.userMapper = userMapper;
        this.userService = userService;
    }

    @ModelAttribute(name = "userModel")
    public UserRegisterBindingModel userModel() {
        return new UserRegisterBindingModel();
    }
@PreAuthorize("!isAuthenticated()")
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("userModel") UserRegisterBindingModel userModel,
                           BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userModel.getPassword().equals(userModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel", bindingResult);
            return "redirect:/users/register";
        }
        UserServiceModel userServiceModel = this.userMapper.mapUserRegisterBindingModelToUserServiceModel(userModel);
        this.userService.register(userServiceModel);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    @PreAuthorize("!isAuthenticated()")
    public String login() {

        return "login";
    }

    @PostMapping("/login-err")
    @PreAuthorize("!isAuthenticated()")
    public String failedLogin(
            @ModelAttribute("email") String email,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("bad_credentials", true);
        redirectAttributes.addFlashAttribute("email", email);
        return "redirect:/users/login";
    }

}
