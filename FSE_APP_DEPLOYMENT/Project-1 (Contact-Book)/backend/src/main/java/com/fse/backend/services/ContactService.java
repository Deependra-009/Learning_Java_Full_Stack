package com.fse.backend.services;

import com.fse.backend.dto.req.ContactRequestBean;
import com.fse.backend.dto.res.ContactResponseBean;
import com.fse.backend.dto.res.StatusMessage;
import com.fse.backend.entity.ContactEntity;
import com.fse.backend.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactResponseBean addContact(ContactRequestBean contactRequestBean) throws Exception {
        Long count=this.contactRepository.checkPhoneNumberAlreadyExist(contactRequestBean.getPhoneNumber());
        if(count==0){
            ContactEntity contactEntity=this.contactRepository.save(
                    ContactEntity
                            .builder()
                            .name(contactRequestBean.getName())
                            .phoneNumber(contactRequestBean.getPhoneNumber())
                            .build()
            );

            return ContactResponseBean.builder()
                    .id(contactEntity.getId())
                    .name(contactEntity.getName())
                    .phoneNumber(contactEntity.getPhoneNumber())
                    .build();
        }

        throw new Exception("Phone Number already exist");
    }
    public ContactResponseBean updateContact(ContactRequestBean contactRequestBean,Long id) throws Exception {
        Long count=this.contactRepository.checkPhoneNumberAlreadyExist(contactRequestBean.getPhoneNumber());
        if(count!=0){
            throw new Exception("Phone Number Already Exist");
        }
        ContactEntity contactEntity=this.contactRepository.save(
                ContactEntity
                        .builder()
                        .id(id)
                        .name(contactRequestBean.getName())
                        .phoneNumber(contactRequestBean.getPhoneNumber())
                        .build()
        );
        return ContactResponseBean.builder()
                .id(contactEntity.getId())
                .name(contactEntity.getName())
                .phoneNumber(contactEntity.getPhoneNumber())
                .build();
    }

    public StatusMessage deleteContact(Long id) throws Exception {
        try{
            this.contactRepository.delete(ContactEntity.builder().id(id).build());
            return StatusMessage.builder().message("DELETE SUCCESSFULLY").build();
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public List<ContactResponseBean> getAllContact(){
        List<ContactEntity> contactEntityList=this.contactRepository.findAll();
        return contactEntityList.stream().map(
                e->ContactResponseBean
                        .builder()
                        .id(e.getId())
                        .name(e.getName())
                        .phoneNumber(e.getPhoneNumber())
                        .build()
        ).toList();
    }
}
