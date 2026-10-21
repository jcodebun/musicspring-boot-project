package com.music.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.music.entity.SongEntity;

public interface SongRepository extends JpaRepository<SongEntity, Long>{
	
	public SongEntity findById(long id);

}


