package com.wangy.core.shiro;

import com.wangy.core.spring.SpringCacheManagerWrapper;
import com.wangy.utils.SpringContextUtil;
import com.wangy.utils.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.mgt.AuthenticatingSecurityManager;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.SessionValidationScheduler;
import org.apache.shiro.session.mgt.ValidatingSessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.TaskScheduler;

/**
 * shiro 相关
 */
@Configuration
public class ShiroBeanConfig implements ApplicationContextAware {

    private ApplicationContext context = null;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }


    /**
     * 自定义权限验证类
     * @return
     */
    @Bean
    public AuthorizingRealm userRealm(){
        AuthorizingRealm realm =  new UserRealm();
        return  realm;
    }
    /**
     *  安全管理器
     * @return
     */
    @Bean
    public AuthenticatingSecurityManager securityManager(){
        AuthenticatingSecurityManager securityManager = new DefaultSecurityManager();
        securityManager.setRealm(userRealm());
        SecurityUtils.setSecurityManager(securityManager);
        return  securityManager;
    }



    /**
     * 会话管理
     * @return
     */
    @Bean
    public SessionManager sessionManager(){
        SessionManager sessionManager =new  OnlineWebSessionManager();
        ((OnlineWebSessionManager) sessionManager).setSessionFactory(onlineSessionFactory());
        ((OnlineWebSessionManager) sessionManager).setSessionDAO(onlineSessionDAO());
        ((OnlineWebSessionManager) sessionManager).setCacheManager(shiroCacheManager());
        ((OnlineWebSessionManager) sessionManager).setSessionIdCookieEnabled(true);
        ((OnlineWebSessionManager) sessionManager).setSessionIdCookie(sessionIdCookie());
//        ((OnlineWebSessionManager) sessionManager).setSessionValidationSchedulerEnabled(true);
//        ((OnlineWebSessionManager) sessionManager).setSessionValidationScheduler(sessionValidationScheduler());
        return sessionManager;
    }


    /**
     * session 工厂
     * @return
     */
    @Bean
    public SessionFactory onlineSessionFactory(){
        SessionFactory sessionFactory = new OnlineSessionFactory();
        return sessionFactory;
    }

    /**
     * uid(session id) 生成策略
     * @return
     */
    @Bean
    public SessionIdGenerator sessionIdGenerator(){
        return new JavaUuidSessionIdGenerator();
    }

    /**
     * 会话验证调度
     */
    public SessionValidationScheduler sessionValidationScheduler(){
        SessionValidationScheduler sessionValidationScheduler = new SpringSessionValidationScheduler();
        ((SpringSessionValidationScheduler) sessionValidationScheduler).setSessionManager((ValidatingSessionManager) sessionManager());
//        ((SpringSessionValidationScheduler) sessionValidationScheduler).setScheduler();//定时器先不加
        return sessionValidationScheduler;
    }

    /**
     * 会话保持的DAO
     * @return
     */
    @Bean
    public SessionDAO onlineSessionDAO(){
        OnlineSessionDAO onlineSessionDAO = new OnlineSessionDAO();
        onlineSessionDAO.setSessionIdGenerator(sessionIdGenerator());
        onlineSessionDAO.setActiveSessionsCacheName("shiro.active.session.cacheName");
        return  onlineSessionDAO;
    }

    /**
     * shiro 缓存管理器
     * 适配器，将net.sf.ehcache.CacheManager 转换为org.apache.shiro.cache.CacheManager;
     * @return
     */
    @Bean
    public CacheManager shiroCacheManager(){
        CacheManager cacheManager = new SpringCacheManagerWrapper();
        ((SpringCacheManagerWrapper) cacheManager).setCacheManager(ehCacheCacheManager());

        return cacheManager;
    }

    /**
     * ehcache 缓存工厂
     * @return
     */
    @Bean
    public EhCacheManagerFactoryBean cacheManagerFactory(){
        EhCacheManagerFactoryBean cacheManagerFactory = new EhCacheManagerFactoryBean();
        String path = "classpath:ehcache/ehcache.xml";
        Resource resource = context.getResource(path);
        cacheManagerFactory.setConfigLocation(resource);
        return cacheManagerFactory;
    }

    /**
     * ehcache 管理器
     * @return
     */
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(){
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(cacheManagerFactory().getObject());
        return ehCacheCacheManager;
    }

    /**
     * 会话Cookie模板 管理
     * @return
     */
    @Bean
    public Cookie sessionIdCookie(){
        Cookie cookie = new SimpleCookie();
        cookie.setName(SpringContextUtil.getProperty("shiro.uid.cookie.name"));
        cookie.setDomain(SpringContextUtil.getProperty("shiro.uid.cookie.domain"));
        cookie.setHttpOnly(true);
        cookie.setMaxAge(-1);
        cookie.setPath(SpringContextUtil.getProperty("shiro.uid.cookie.path"));
        return cookie;
    }

    /**
     * 会话Cookie模板 管理
     * @return
     */
    @Bean
    public Cookie rememberMeCookie(){
        Cookie cookie = new SimpleCookie();
        cookie.setName(SpringContextUtil.getProperty("shiro.uid.cookie.name"));
        cookie.setDomain(SpringContextUtil.getProperty("shiro.uid.cookie.domain"));
        cookie.setHttpOnly(true);
        cookie.setMaxAge(StringUtil.strToInt(SpringContextUtil.getProperty("shiro.uid.rememeberMe.cookie.maxAge")));
        cookie.setPath(SpringContextUtil.getProperty("shiro.uid.cookie.path"));
        return cookie;
    }
//
//    /**
//     * 设置SecurityUtils，相当于调用SecurityUtils.setSecurityManager(securityManager)
//     * @param sessionManager
//     * @return
//     */
//    @Bean
//    public MethodInvokingBean setSecurityManager(SessionManager sessionManager){
//        MethodInvokingFactoryBean invokingFactoryBean = new MethodInvokingFactoryBean();
//        invokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
//        invokingFactoryBean.setArguments(sessionManager);
//        return invokingFactoryBean;
//    }


}
