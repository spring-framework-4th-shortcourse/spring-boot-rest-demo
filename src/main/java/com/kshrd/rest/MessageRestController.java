package com.kshrd.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kshrd.model.Message;
import com.kshrd.service.MessageService;

//@RestController = @Controller + @ResponseBody
@Controller
public class MessageRestController {
	
	@Autowired
	MessageService messageService;
	
	@ResponseBody
	@GetMapping("/messages")
	public List<Message> getAllMessages(){
		return messageService.getAllMessage();
	}
	
	@ResponseBody
	@GetMapping("/messages/{id}")
	public Message getMessageById(@PathVariable Integer id){
		return messageService.getMessageById(id);
	}
	
	@ResponseBody
	@PostMapping("/messages")
	public boolean createMessage(@RequestBody Message message){
		System.out.println(message);
		return messageService.createMessage(message);
	}
	
	@ResponseBody
	@DeleteMapping("/messages/{id}")
	public boolean removeMessageById(@PathVariable Integer id){
		return messageService.removeMessage(id);
	}
	
	@ResponseBody
	@PutMapping("/messages")
	public boolean updateMessageById(@RequestBody Message message){
		return messageService.updateMessage(message);
	}
	
}
