package com.kshrd.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kshrd.model.Message;
import com.kshrd.service.MessageService;

@RestController //= @Controller + @ResponseBody
public class MessageRestController {
	
	@Autowired
	MessageService messageService;
	
	@GetMapping("/messages")
	public Map<String, Object> getAllMessages(){
		List<Message> messages = messageService.getAllMessage();
		
		Map<String, Object> map = new HashMap<>();
		map.put("message", "Get Successfully!");
		map.put("status", true);
		map.put("data", messages);
		
		return map;
	}
	
	@GetMapping("/messages/{id}")
	public ResponseEntity<Message> getMessageById(@PathVariable Integer id){
		Message message = messageService.getMessageById(id);
		if(message == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return ResponseEntity.ok(message);		
	}
	
	@PostMapping("/messages")
	public Map<String, Object> createMessage(@RequestBody Message message){
		boolean status = messageService.createMessage(message);
		Map<String, Object> map = new HashMap<>();
		map.put("message", "Create Successfully!");
		map.put("status", status);
		return map;
	}
	
	@DeleteMapping("/messages/{id}")
	public ResponseEntity<?> removeMessageById(@PathVariable Integer id){
		if(!messageService.removeMessage(id))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	@PutMapping("/messages")
	public ResponseEntity<?> updateMessageById(@RequestBody Message message){
		if(!messageService.updateMessage(message))
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
