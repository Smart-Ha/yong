package com.wangy.core.shiro;

import com.wangy.core.spring.SpringCacheManagerWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

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
    public DefaultWebSecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm());
        SecurityUtils.setSecurityManager(securityManager);
        return  securityManager;
    }


//    /**
//     * ehcache 缓存工厂
//     * @return
//     */
//    @Bean
//    public EhCacheManagerFactoryBean cacheManagerFactory(){
//        EhCacheManagerFactoryBean cacheManagerFactory = new EhCacheManagerFactoryBean();
//        String path = "classpath:ehcache/ehcache.xml";
//        Resource resource = context.getResource(path);
//        cacheManagerFactory.setConfigLocation(resource);
//        return cacheManagerFactory;
//    }
//
//    /**
//     * ehcache 管理器
//     * @return
//     */
//    @Bean
//    public EhCacheCacheManager ehCacheCacheManager(){
//        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
//        ehCacheCacheManager.setCacheManager(cacheManagerFactory().getObject());
//        return ehCacheCacheManager;
//    }
//
//    /**
//     * shiro 缓存管理器
//     * 适配器，将net.sf.ehcache.CacheManager 转换为org.apache.shiro.cache.CacheManager;
//     * @return
//     */
//    @Bean
//    public CacheManager shiroCacheManager(){
//        CacheManager cacheManager = new SpringCacheManagerWrapper();
//        ((SpringCacheManagerWrapper) cacheManager).setCacheManager(ehCacheCacheManager());
//
//        return cacheManager;
//    }
//
//
//
//
//    /**
//     * session 工厂
//     * @return
//     */
//    @Bean
//    public SessionFactory onlineSessionFactory(){
//        SessionFactory sessionFactory = new OnlineSessionFactory();
//        return sessionFactory;
//    }
//
//    /**
//     * 会话管理
//     * @return
//     */
//    @Bean
//    public SessionManager sessionManager(){
//        SessionManager sessionManager =new  OnlineWebSessionManager();
//        ((OnlineWebSessionManager) sessionManager).setSessionFactory(onlineSessionFactory());
//        ((OnlineWebSessionManager) sessionManager).setCacheManager(shiroCacheManager());
//        return sessionManager;
//    }
//




//    /**
//     * 会话Cookie模板 管理
//     * @return
//     */
//    @Bean
//    public Cookie sessionIdCookie(){
//        Cookie cookie = new SimpleCookie();
//        cookie.setHttpOnly(true);
//        cookie.setMaxAge(-1);
//        cookie.setName("yong.session.id");
//        return cookie;
//    }
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
