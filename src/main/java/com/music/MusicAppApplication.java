package com.music;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.music.entity.SongEntity;
import com.music.services.SongService;

@SpringBootApplication
public class MusicAppApplication {

	public static void main(String[] args) {

		// SongService service = new SongService();
		ApplicationContext applicationContext = SpringApplication.run(MusicAppApplication.class, args);

		SongService service = applicationContext.getBean(SongService.class);

		System.out.println("Welcome To Music App, Where you can Add, View, Update and Delete Songs: ");

		Scanner sc = new Scanner(System.in);

		System.out.println("What You Looking for? please choose the Options:");
		System.out.println("Press 1 to Add the song");
		System.out.println("Press 2 to View the songs list");
		System.out.println("Press 3 to Update the song");
		System.out.println("Press 4 to Delete the song");

		int option = sc.nextInt();

		switch (option) {
		case 1: {
			System.out.println("Please Enter Song Name:");
			String songName = sc.next();
			System.out.println("Please Enter Artist Name:");
			String artistName = sc.next();
			try {
				SongEntity song = new SongEntity();
				song.setSongName(songName);
				song.setArtist(artistName);
				
				SongEntity sDto = service.add(song);
				System.out.println(sDto + "Song is added..");

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		case 2: {
			List<SongEntity> list = service.list();
			for (SongEntity songEntity : list) {
				System.out.println("Id: "+songEntity.getId()+ " Song Name: "+songEntity.getSongName()+ " Artist: "+songEntity.getArtist());
			}

		}
		case 3: {
               System.out.println("Enter the Song Id to Update");
               long id = sc.nextInt();
               sc.nextLine();
               SongEntity song = service.findById(id);
               System.out.println("Enter Updated Song Name:");
               String songName = sc.nextLine();
               System.out.println("Enter Updated Artist Name:");
               String songArtist = sc.nextLine();
               song.setSongName(songName);
               song.setArtist(songArtist);
               service.update(song);
               System.out.println("Song is updated now...");
		}
		case 4: {
			System.out.println("Enter the Song Id to Delete");
            long id = sc.nextInt();
            service.delete(id);
            System.out.println("Song is deleted now...");
            sc.nextLine();
		}
		default:
			System.out.println("Not a Valid Option");
		}

	}

}
