package com.manjula.starter.controller;

import com.manjula.starter.dto.RoleDto;
import com.manjula.starter.dto.RolePermissionDto;
import com.manjula.starter.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Manjula Jayawardana
 */
@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "user/role/roles";
    }

    @GetMapping(value = "/save")
    public String getSaveForm(Model model) {
        model.addAttribute("role", RoleDto.builder().build());
        return "user/role/save";
    }

    // model attribute with name is required for validation to work. then bindingresult should follow.
    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("role") RoleDto roleDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("role", roleDto);
            return "user/role/save";
        }
        return "redirect:/roles";
    }

    @GetMapping(value = "/{id}/permissions")
    public String addPermissions(@PathVariable Long id, Model model) {
        model.addAttribute("rolePermission", RolePermissionDto.builder().roleId(id).build());
        model.addAttribute("permissions", roleService.findAllPermissions());
        return "user/role/role-permissions";
    }

    @PostMapping(value = "/permissions/save")
    public String addPermissions(@ModelAttribute("rolePermission") RolePermissionDto rolePermission, Model model) {
        roleService.savePermissions(rolePermission);
        return "redirect:/roles/1/permissions";
    }

}
