package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.app.model.Employee;

@Service
public class EmailServiceImpl extends EmailService {
	@Autowired
    private JavaMailSender javaMailSender;

    public void sendNewEmployeeEmail(Employee newEmployee, Employee manager) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(manager.getEmail());
        message.setSubject("New Employee Addition");
        message.setText(String.format(
                "%s will now work under you. Mobile number is %s and email is %s",
                newEmployee.getEmployeeName(),
                newEmployee.getPhoneNumber(),
                newEmployee.getEmail()
        ));

        javaMailSender.send(message);
    }

}
