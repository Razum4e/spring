package com.github.razum4e.spring.bookPro5;

import com.github.razum4e.spring.bookPro5.message.MessageRenderer;
import com.github.razum4e.spring.bookPro5.oracle.Oracle;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigWithBeanFactory {
    private static final String XML_FILE_MESSAGE = "config_message.xml";
    private static final String XML_FILE_ORACLE = "config_oracle.xml";

    public static void main(String... args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                XML_FILE_MESSAGE,
                XmlConfigWithBeanFactory.class
        );
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        mr.render();
        
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
        rdr.loadBeanDefinitions(new ClassPathResource(
                XML_FILE_ORACLE,
                XmlConfigWithBeanFactory.class
        ));
        Oracle oracle = (Oracle) factory.getBean("oracle");

        System.out.println(oracle.defineMeaningOfLife());
    }
}
