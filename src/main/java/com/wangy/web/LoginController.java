package com.wangy.web;

import com.wangy.constant.Constants;
import com.wangy.constant.UserConstant;
import com.wangy.utils.StringUtil;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
@Controller
public class LoginController extends BaseController {


    @ApiOperation(value = "登录页面")
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(HttpServletRequest request) {
        return "login";
    }



    @ApiOperation(value = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        String verifyCode = request.getParameter("verifyCode");
        String verifyCodeText = (String) request.getSession().getAttribute("verifyCode");
        if(StringUtil.isEmpty(username) || StringUtil.isEmpty(password) || StringUtil.isEmpty(verifyCode)){
            model.addAttribute(Constants.ERROR,UserConstant.EMPTY_PARAM);
        }
        if(!verifyCodeText.equalsIgnoreCase(verifyCode)){
            model.addAttribute(Constants.ERROR,UserConstant.INVALID_VCODE);
        }
        if(model.containsAttribute(Constants.ERROR)){
            return "login";
        }


        UsernamePasswordToken upToken = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(upToken);
        } catch (UnknownAccountException e) {
            model.addAttribute(Constants.ERROR,UserConstant.INVALID_ACCOUNT);
        }catch (IncorrectCredentialsException e) {
            model.addAttribute(Constants.ERROR,UserConstant.INVALID_PASSWORD);
        }catch (LockedAccountException e) {
            model.addAttribute(Constants.ERROR,UserConstant.ACCOUNT_LOCKED);
        }
        if(model.containsAttribute(Constants.ERROR)){
            return "login";
        }
        return "index";
    }



    @ApiOperation(value = "退出登录")
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        // shiro退出登录
        SecurityUtils.getSubject().logout();
        // 跳回原地址
        String redirectUrl = request.getHeader("Referer");
        if (null == redirectUrl) {
            redirectUrl = "/";
        }
        return "redirect:" + redirectUrl;
    }

}
