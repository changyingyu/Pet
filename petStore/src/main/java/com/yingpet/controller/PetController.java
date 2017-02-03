package com.yingpet.controller;

import com.yingpet.model.PageablePetList;
import com.yingpet.model.PetEntity;
import com.yingpet.repository.BlogRepository;
import com.yingpet.repository.PetRepository;
import com.yingpet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Stream;


@Controller
@Transactional
public class PetController {

    @Autowired
    BlogRepository blogRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PetRepository petRepository;



    private static final String[] possibleStatus = {"available", "pending" , "sold"};

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pet", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<PetEntity>> getPets() {


        Pageable pageable = new PageRequest(0, 10);
        Page<PetEntity> petPage = petRepository.findAll(pageable);
        PageablePetList pageablePetList = new PageablePetList();
        pageablePetList.setCurrentPage(petPage.getNumber());
        pageablePetList.setTotalItems((int)petPage.getTotalElements());
        pageablePetList.setTotalPages(petPage.getTotalPages());
        List<PetEntity> pets = petPage.getContent();

        pageablePetList.setPets(pets);
        return ResponseEntity.ok(pets);

    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/pet", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<PetEntity> createPet(@RequestBody PetEntity pet) {

        Assert.notNull(pet.getName(), "Name must not be null");

        if (pet.getStatus() == null){
            throw new IllegalArgumentException("Status cannot be null");
        }
        if (!Stream.of(possibleStatus).anyMatch(x -> x.equals(pet.getStatus()))){
            throw new IllegalArgumentException("Status must be ['available', 'pending', 'sold']");
        }

        PetEntity created = petRepository.saveAndFlush(pet);
        return ResponseEntity.ok(created);

    }



    @CrossOrigin(origins = "*")
    @RequestMapping( value = "/pet/{petId}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<PetEntity> findPet(@PathVariable("petId") Integer petId) {
        //PetEntityt pet = petService.findPetById(petId);
        Assert.notNull(petId, "Id must not be null");

        PetEntity pet = petRepository.findById(petId);
        if (pet == null) {
            throw new EntityNotFoundException("Pet does not exist");
        }

            return ResponseEntity.ok(pet);
    }


    @CrossOrigin(origins = "*")
    @RequestMapping( value = "/pet/{petId}",method = RequestMethod.DELETE)
    @ResponseBody

    public ResponseEntity<String> deletePet(@PathVariable("petId") Integer petId) {
       // petService.deletePet(petId);

        Assert.notNull(petId, "Id must not be null");
        //findPetById(id);
        Integer result = petRepository.deleteById(petId);

        return ResponseEntity.ok("{'status' : 'ok'}");
    }


}
