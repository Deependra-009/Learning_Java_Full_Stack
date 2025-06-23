package com.fse.backend.controller;

import com.fse.backend.dto.req.ContactRequestBean;
import com.fse.backend.dto.res.ContactResponseBean;
import com.fse.backend.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact-book")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping("/add")
    public ResponseEntity<ContactResponseBean> addContact(
            @RequestBody ContactRequestBean contactRequestBean
            ) throws Exception {
        return new ResponseEntity<>(this.contactService.addContact(contactRequestBean), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<ContactResponseBean>> getAllContacts(){
        return new ResponseEntity<>(this.contactService.getAllContact(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.contactService.deleteContact(id),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ContactResponseBean> updateContact(
            @RequestBody ContactRequestBean contactRequestBean,
            @PathVariable Long id
    ) throws Exception {
        return new ResponseEntity<>(this.contactService.updateContact(contactRequestBean,id),HttpStatus.OK);
    }



}
