package com.example.demo.controller;


import com.example.demo.model.Contact;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {
    @GetMapping
    ResponseEntity<Contact> getAll() {
        return ResponseEntity.ok(new Contact());
    }

    @PostMapping
    ResponseEntity<Contact> create(@RequestBody Contact contact) {
        return ResponseEntity.ok(contact);
    }

    @PutMapping("/{id}")
    ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody Contact contact) {
        return ResponseEntity.ok(contact.toString() + " : UPDATED ID->" + id);
    }
}
