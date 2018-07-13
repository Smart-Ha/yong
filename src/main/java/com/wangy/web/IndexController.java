package com.wangy.web;

import com.wangy.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@Api(value = "首页", description = "首页管理")
public class IndexController extends BaseController {



    @ApiOperation(value = "首页")
    @RequestMapping(value = {"","/"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request) {
        ModelMap model = new ModelMap();
        model.addAttribute("message","hello,world");
        return "index";
    }
}
