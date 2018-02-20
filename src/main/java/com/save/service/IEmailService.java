package com.save.service;

import org.springframework.mail.SimpleMailMessage;

public interface IEmailService {
	
	public void sendEmail(SimpleMailMessage email);

}
