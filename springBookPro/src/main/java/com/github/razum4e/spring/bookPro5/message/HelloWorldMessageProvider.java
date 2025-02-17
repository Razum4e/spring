package com.github.razum4e.spring.bookPro5.message;

import org.springframework.stereotype.Component;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider {

    public HelloWorldMessageProvider(){
        System.out.println(" --> HelloWorldMessageProvider: constructor caled");
    }

    @Override
    public String getMessage() {
        return "Hello World!";
    }
}
