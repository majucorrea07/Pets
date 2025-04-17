package com.Pets.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Pets.Entities.Pet;
import com.Pets.Repository.PetRepository;

@Service
public class PetService {
private final PetRepository petRepository;
	
	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}
	
	public Pet savePet (Pet pet) {
		return petRepository.save(pet);
	}
	
	public Pet getPetById(Long id) {
		return petRepository.findById(id).orElse(null);
	}
	
	public List<Pet> getAllPet() {
		return petRepository.findAll();
		}
	public Pet alteraPet (Long id, Pet alteraPet) {
		Optional<Pet> existePet = petRepository.findById(id);
		if (existePet.isPresent()) {
			alteraPet.setId(id);
			return petRepository.save(alteraPet);
		}
		else {
			return null;
		}
		}
		public boolean deletePet (Long id) {
			Optional<Pet> existePet = petRepository.findById(id);
			if (existePet.isPresent()) {
				petRepository.deleteById(id);
				return true;
			} else {
				return false;
			}
		}
}

