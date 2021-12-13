package org.sid;

import java.util.Date;

import org.sid.dao.EtudiantRepository;
import org.sid.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScolariteApplication implements CommandLineRunner {
	@Autowired
	private EtudiantRepository etudiantRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ScolariteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		etudiantRepository.save(new Etudiant(null, "Mohamed", "med@gmail.com", new Date(), 40));
		etudiantRepository.save(new Etudiant(null, "Hassan", "hassan@gmail.com", new Date(), 30));
		etudiantRepository.save(new Etudiant(null, "Imane", "imane@gmail.com", new Date(), 40));
		etudiantRepository.findAll().forEach(et -> {
			System.out.println(et.toString());
		});
		Etudiant et = etudiantRepository.findById(1L).get();
		
		System.out.println("------------------------\n"+et.getName());
		System.out.println("************************");
		etudiantRepository.findByScore(40).forEach(ett -> {
			System.out.println(ett.getName());
		});
	}

}
