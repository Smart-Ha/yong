package com.wangy.web;

import com.wangy.entity.auth.Role;
import com.wangy.service.IRoleService;
import com.wangy.service.impl.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 角色相关
 */
@Controller
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "获取所有角色")
    @RequestMapping(value = "/getAllRoles", method = RequestMethod.POST)
    public String getAllRoles(Model model){
        List<Role> roles = roleService.findAllRoles();
        model.addAttribute("roles", roles);
        return "admin/role";
    }


    @ApiOperation(value = "添加角色")
    @RequestMapping(value = "/addRole", method = RequestMethod.POST)
    public String addRole(Model model){
        Role role = new Role();
        role = roleService.addRole(role);
        return "redirect:/getAllRoles";
    }


    @ApiOperation(value = "删除角色")
    @RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
    public String delteRole(Model model, @RequestParam("role")String role){
        boolean b = roleService.deleteRole(role);
        return "redirect:/getAllRoles";
    }


}
