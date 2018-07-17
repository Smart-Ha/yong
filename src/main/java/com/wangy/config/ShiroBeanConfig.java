package com.wangy.config;

import com.wangy.upms.domain.UpmsRealm;
import com.wangy.upms.shiro.UpmsSessionDao;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.config.MethodInvokingBean;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * shiro 相关
 */
@Configuration
public class ShiroBeanConfig {


    /**
     *  安全管理器
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        return  securityManager;
    }

    /**
     * 会话管理
     * @return
     */
    @Bean
    public SessionManager sessionManager(UpmsSessionDao sessionDAO){
        SessionManager sessionManager = new DefaultWebSessionManager();

        return sessionManager;
    }

    /**
     * 会话Cookie模板 管理
     * @return
     */
    @Bean
    public Cookie sessionIdCookie(){
        Cookie cookie = new SimpleCookie();
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        cookie.setName("yong.session.id");
        return cookie;
    }

    /**
     * 设置SecurityUtils，相当于调用SecurityUtils.setSecurityManager(securityManager)
     * @param sessionManager
     * @return
     */
    @Bean
    public MethodInvokingBean setSecurityManager(SessionManager sessionManager){
        MethodInvokingFactoryBean invokingFactoryBean = new MethodInvokingFactoryBean();
        invokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        invokingFactoryBean.setArguments(sessionManager);
        return invokingFactoryBean;
    }

    /**
     *
     * @return
     */
    public AuthorizingRealm upmsRealm(){
        AuthorizingRealm realm =  new UpmsRealm();
        return  realm;
    }
}
