package com.wangy.web;

import com.wangy.entity.User;
import com.wangy.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Api(value = "首页", description = "首页管理")
public class IndexController extends BaseController {

    @Autowired
    private IUserService userService;


    @ApiOperation(value = "首页")
    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("message","hello,world");
        return "index";
    }

    @RequestMapping("/usr/{userId}")
    public String showUser(Model model, @PathVariable("userId") Long userId) {
        User usr = userService.findById(userId);
        model.addAttribute("user", usr);
        return "user/index";
    }
}
