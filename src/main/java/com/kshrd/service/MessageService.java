package com.kshrd.service;

import java.util.List;

import com.kshrd.model.Message;

public interface MessageService {
	
	public List<Message> getAllMessage();
	
	public Message getMessageById(Integer id);
	
	public boolean createMessage(Message message);
	public boolean removeMessage(Integer id);
	public boolean updateMessage(Message message);
	
}
