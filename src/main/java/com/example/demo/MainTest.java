package com.example.demo;

import com.example.demo.model.Contact;
import com.example.demo.model.util.Label;

public class MainTest {
    public static void main(String[] args) {
        Contact contact = new Contact();
        contact.setId(1);
        contact.setName("Karen");
        contact.setSurname("Darbinyan");
        contact.setPhone("098156247");
        contact.setEmail("kar31100@gmail.com");
        contact.setPhoneLabel(Label.Work);
        contact.setEmailLabel(Label.Personal);


        System.out.println(contact.stringify());

    }
}
