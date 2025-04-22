package com.Pets.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Pets.Entities.Pet;
import com.Pets.Service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {
	private final PetService petService;

	public PetController (PetService petService) {
		this.petService = petService;
	}

	@GetMapping("/")
	public ResponseEntity<List<Pet>>getAllPet(){
		List<Pet> pets = petService.getPetAll();
		return ResponseEntity.ok(pets);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Pet> getPetById(@PathVariable Long id){
		Pet pet = petService.getPetById(id);
		if (pet !=null) {
			return ResponseEntity.ok(pet);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<Pet> criarPet(@RequestBody Pet pet){
		Pet criarPet = petService.salvaPet(pet);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarPet);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pet> alterarPet(@PathVariable Long id, @RequestBody Pet pet){
	Pet alterarPet = petService.alterarPet(id, pet);
		if(alterarPet !=null) {
			return ResponseEntity.ok(alterarPet);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletePet(@PathVariable Long id){
		boolean deleted = petService.deletePet(id);
		if(deleted) {
			return ResponseEntity.ok().body("Pet apagado com sucesso!");
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
