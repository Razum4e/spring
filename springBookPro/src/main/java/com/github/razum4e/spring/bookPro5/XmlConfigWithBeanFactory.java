package com.github.razum4e.spring.bookPro5;

import com.github.razum4e.spring.bookPro5.message.MessageProvider;
import com.github.razum4e.spring.bookPro5.message.MessageRenderer;
import com.github.razum4e.spring.bookPro5.oracle.Oracle;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import static com.github.razum4e.spring.bookPro5.XmlConfigWithBeanFactory.Configuration.XML_FILE_MESSAGE;
import static com.github.razum4e.spring.bookPro5.XmlConfigWithBeanFactory.Configuration.XML_FILE_MESSAGE_ANNO;
import static com.github.razum4e.spring.bookPro5.XmlConfigWithBeanFactory.Configuration.XML_FILE_ORACLE;

public class XmlConfigWithBeanFactory {
    interface Configuration {
        String XML_FILE_MESSAGE = "config_message.xml";
        String XML_FILE_MESSAGE_ANNO = "config_message_annotation.xml";
        String XML_FILE_ORACLE = "config_oracle.xml";
    }

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
}
