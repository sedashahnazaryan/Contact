package com.example.demo.service.impl;

import com.example.demo.model.Contact;
import com.example.demo.repository.ContactRepository;
import com.example.demo.service.ContactService;
import com.example.demo.util.validator.Validation;
import com.example.demo.util.validator.Validator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact create(Contact contact) {
        if (!Validator.checkEmail(contact.getEmail(), Validation.regexEmail)) {


            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong");
        } else if (!Validator.checkPhone(contact.getPhone(), Validation.regexPhone)) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong");
        } else if(!Validator.checkLabel(contact.getPhoneLabel(),Validation.label)){

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong");

        } else if(!Validator.checkLabel(contact.getEmailLabel(),Validation.label)) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong");
        }else
            return contactRepository.save(contact);
        }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    @Transactional
    public Contact update(Contact contact, int id) {
        Contact fromDb = contactRepository.findById(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "wrong ");
        });
        fromDb.setName(contact.getName());
        fromDb.setSurname(contact.getSurname());
        fromDb.setPhone(contact.getPhone());
        fromDb.setPhoneLabel(contact.getPhoneLabel());
        fromDb.setEmail(contact.getEmail());
        fromDb.setEmailLabel(contact.getEmailLabel());
        return fromDb;
    }

    @Override
    public void delete(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public List<Contact> getByKey(String key) {
        return getAll()
                .stream()
                .filter(item -> item.stringify().toLowerCase(Locale.ROOT)
                        .contains(key.toLowerCase(Locale.ROOT))
                )
                .collect(Collectors
                        .toList()
                );

    }
}
