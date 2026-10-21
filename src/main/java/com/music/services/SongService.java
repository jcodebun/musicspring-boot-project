package com.music.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.entity.SongEntity;
import com.music.repository.SongRepository;

@Service
public class SongService {

	@Autowired
	public SongRepository repository;

	public SongEntity add(SongEntity entity) {
		SongEntity dto = null;
		try {
			dto = repository.save(entity);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dto;

	}

	public List<SongEntity> list() {
		return repository.findAll();
	}

	public SongEntity findById(long id) {
		return repository.findById(id);
	}

	public void update(SongEntity entity) {
		repository.saveAndFlush(entity);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

}
