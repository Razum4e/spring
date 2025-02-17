package com.github.razum4e.spring.bookPro5;

import com.github.razum4e.spring.bookPro5.message.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class AnnoConfigBeanFactory {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
    }

    //@ComponentScan(basePackages = "com.github.razum4e.spring.bookPro5.message")
    //тогда не нужны @Bean's и методы
    @Configuration
    public static class HelloWorldConfiguration {
        @Bean
        public MessageProvider provider() {
            return new HelloWorldMessageProvider();
        }

        @Bean
        public MessageRenderer renderer(){
            MessageRenderer renderer = new StandardOutMessageRenderer();
            renderer.setMessageProvider(provider());
            return renderer;
        }
    }
}
