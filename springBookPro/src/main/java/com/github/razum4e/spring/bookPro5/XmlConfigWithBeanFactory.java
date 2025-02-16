package com.github.razum4e.spring.bookPro5;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

public class XmlConfigWithBeanFactory {
    private static final String XML_FILE = "xml-config-bean-factory.xml";

    public static void main(String... args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader rdr = new XmlBeanDefinitionReader(factory);
        rdr.loadBeanDefinitions(
                new ClassPathResource(XML_FILE, XmlConfigWithBeanFactory.class)
        );
        Oracle oracle = (Oracle) factory.getBean("oracle");

        System.out.println(oracle.defineMeaningOfLife());
    }
}
