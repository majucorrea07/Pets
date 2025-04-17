package com.Pets.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Pets.Entities.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {

}
