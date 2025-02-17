package com.github.razum4e.spring.bookPro5;

import com.github.razum4e.spring.bookPro5.message.MessageProvider;
import com.github.razum4e.spring.bookPro5.message.MessageRenderer;
import com.github.razum4e.spring.bookPro5.oracle.Oracle;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import static com.github.razum4e.spring.bookPro5.XmlConfigWithBeanFactory.Configuration.XML_FILE_CONFIG;
import static com.github.razum4e.spring.bookPro5.XmlConfigWithBeanFactory.Configuration.XML_FILE_MESSAGE_ANNO;

public class XmlConfigWithBeanFactory {
    interface Configuration {
        String XML_FILE_CONFIG = "config_message.xml";
        String XML_FILE_MESSAGE_ANNO = "config_message_annotation.xml";
    }

    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                XML_FILE_CONFIG,
                XmlConfigWithBeanFactory.class
        );
        runGetBean(ctx);

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
        rdr.loadBeanDefinitions(new ClassPathResource(
                XML_FILE_CONFIG,
                XmlConfigWithBeanFactory.class
        ));
        runGetBean(factory);

        GenericXmlApplicationContext genericCtx = new GenericXmlApplicationContext();
        genericCtx.load(
                XmlConfigWithBeanFactory.class,
                XML_FILE_MESSAGE_ANNO
        );
        genericCtx.refresh();
        MessageProvider messageProvider = genericCtx.getBean("provider", MessageProvider.class);
        System.out.println(messageProvider.getMessage());
        genericCtx.close();
    }

    private static void runGetBean(BeanFactory ctx) {
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
        Oracle oracle = ctx.getBean("oracle", Oracle.class);
        System.out.println(oracle.defineMeaningOfLife());
    }
}
