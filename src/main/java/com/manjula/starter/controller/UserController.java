package com.manjula.starter.controller;

import com.manjula.starter.config.security.UserPrinciple;
import com.manjula.starter.dto.PasswordDto;
import com.manjula.starter.dto.UserDto;
import com.manjula.starter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author Manjula Jayawardana
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "")
    public String index(Model model) {
        model.addAttribute("users", userService.findAll());
        return "user/list";
    }

    @GetMapping(value = "/save")
    public String getSaveForm(Model model) {
        model.addAttribute("user", UserDto.builder().build());
        return "user/save";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute UserDto userDto) {
        userService.save(userDto);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String getEidtForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "user/update";
    }

    @PostMapping(value = "/update")
    public String update(@ModelAttribute UserDto userDto) {
        userService.update(userDto);
        return "redirect:/users";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @GetMapping(value = "/password")
    public String editPassword(Model model) {
        model.addAttribute("passwordDto", PasswordDto.builder().build());
        return "user/update-password";
    }

    @PostMapping(value = "/password")
    public String updatePassword(@ModelAttribute PasswordDto passwordDto, RedirectAttributes redirectAttributes) {
        UserPrinciple userPrinciple = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        passwordDto.setUserId(userPrinciple.getUserId());
        userService.updatePassword(passwordDto);
        redirectAttributes.addFlashAttribute("msg", "Password updated successfully.");
        return "redirect:/users/password";
    }

    @GetMapping(value = "/profile")
    public String getProfile(Model model) {
        UserPrinciple userPrinciple = (UserPrinciple) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("userDto", userService.findById(userPrinciple.getUserId()));
        return "user/profile";
    }

}
