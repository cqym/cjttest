package com.chanjet.qm.util;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * obtain the application context bean in spring container.
 *
 */
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext context;

    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextHolder.context = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return context;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name){
        return (T) context.getBean(name);
    }

    public static <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }
}

