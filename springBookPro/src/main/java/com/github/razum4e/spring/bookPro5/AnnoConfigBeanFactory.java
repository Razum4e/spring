package com.github.razum4e.spring.bookPro5;

import com.github.razum4e.spring.bookPro5.message.HelloWorldConfiguration;
import com.github.razum4e.spring.bookPro5.message.MessageRenderer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoConfigBeanFactory {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }
}
