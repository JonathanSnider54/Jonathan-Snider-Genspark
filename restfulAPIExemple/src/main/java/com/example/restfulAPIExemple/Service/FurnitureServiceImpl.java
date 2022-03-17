package com.example.restfulAPIExemple.Service;

import com.example.restfulAPIExemple.entity.Furniture;
import com.example.restfulAPIExemple.repository.FurnitureDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FurnitureServiceImpl implements FurnitureService {

    @Autowired
    public FurnitureDAO furnitureDAO;



    @Override
    public List<Furniture> getFurniture() {

        return furnitureDAO.findAll();
    }

    @Override
    public Furniture getFurnitureById(int furnitureID) {
        Optional<Furniture> f = furnitureDAO.findById(furnitureID);
        Furniture furniture = null;
        if (f.isPresent()) {
            furniture = f.get();
        } else {
            throw new RuntimeException(" Course not found for id :: " + furnitureID);
        }
        return furniture;
    }

    @Override
    public Furniture addFurniture(Furniture furnitureToAdd) {
        return furnitureDAO.save(furnitureToAdd);
    }

    @Override
    public Furniture updateFurniture(Furniture furnitureToUpdate) {
        return furnitureDAO.save(furnitureToUpdate);
    }

    @Override
    public void deleteFurniture(int  furnitureToDelete) {
       furnitureDAO.deleteById(furnitureToDelete);
    }
}
