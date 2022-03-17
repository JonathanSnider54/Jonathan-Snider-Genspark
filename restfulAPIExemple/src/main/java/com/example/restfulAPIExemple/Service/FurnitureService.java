package com.example.restfulAPIExemple.Service;

import com.example.restfulAPIExemple.entity.Furniture;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface FurnitureService {
    public List<Furniture> getFurniture();
    public Furniture getFurnitureById(int furnitureID);
    public Furniture addFurniture(Furniture furnitureToAdd);
    public Furniture updateFurniture(Furniture furnitureToUpdate);
    public void deleteFurniture(int furnitureToDelete);
}
