package com.music.entity;




import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "song")
@Getter
@Setter
public class SongEntity {
	

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	    
	    @Column(name="songName",length = 225)
	    private String songName;
	    
	    @Column(name="artist",length = 225)
	    private String artist;
	    

	    @Override
	public String toString() {
		return "SongEntity [id=" + id + ", songName=" + songName + ", artist=" + artist + "]";
	}

}
