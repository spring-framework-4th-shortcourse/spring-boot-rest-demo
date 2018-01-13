package com.kshrd.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.kshrd.model.Message;

@Service
public class MessageServiceImpl implements MessageService{
	
	private List<Message> messages;
	
	public MessageServiceImpl() {
		messages = new ArrayList<>();
		messages.add(new Message(1, "Hello!"));
		messages.add(new Message(2, "Hello World!"));
		messages.add(new Message(3, "Hi!"));
	}
	
	@Override
	public List<Message> getAllMessage() {
		return messages;
	}

	@Override
	public Message getMessageById(Integer id) {
		for(Message m: messages){
			if(m.getId() == id)
				return m;
		}
		return null;
	}

	@Override
	public boolean createMessage(Message message) {
		return messages.add(message);
	}

	@Override
	public boolean removeMessage(Integer id) {
		for(Message m: messages){
			if(m.getId() == id){
				messages.remove(m);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean updateMessage(Message message) {
		for(int i=0; i<messages.size(); i++){
			if(messages.get(i).getId() == message.getId()){
				messages.set(i, message);
				return true;
			}
		}
		return false;
	}
}
