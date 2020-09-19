package com.mylearningapp.own.serviceImpl;


import com.mylearningapp.own.contact.ContactUsEntity;
import com.mylearningapp.own.dtos.ContactUsDto;
import com.mylearningapp.own.mailservice.EmailSender;
import com.mylearningapp.own.mapper.ContactUsMapper;
import com.mylearningapp.own.repository.ContactUsRepository;
import com.mylearningapp.own.service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactUsServiceImpl implements ContactUsService {

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Autowired
    private ContactUsMapper contactUsMapper;

    @Autowired
    private EmailSender emailSender;


    @Override
    public void userContact(ContactUsDto contactUsDto) {
        ContactUsEntity contactUsEntity = new ContactUsEntity();
        contactUsEntity = contactUsMapper.toEntity(contactUsDto);
        emailSender.sendThanksForContactUs(contactUsEntity.getEmail(),contactUsEntity.getName());
        contactUsRepository.save(contactUsEntity);
    }
}
