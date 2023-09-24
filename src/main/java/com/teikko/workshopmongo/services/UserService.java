package com.teikko.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teikko.workshopmongo.domain.User;
import com.teikko.workshopmongo.repository.UserRepository;
import com.teikko.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		
		if(!obj.isEmpty()) {
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}else {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}
		
		//return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
}