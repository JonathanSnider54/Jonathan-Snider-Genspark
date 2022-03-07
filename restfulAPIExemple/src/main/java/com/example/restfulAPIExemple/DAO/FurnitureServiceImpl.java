package com.example.restfulAPIExemple.DAO;

import com.example.restfulAPIExemple.entity.Furniture;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FurnitureServiceImpl implements FurnitureService {
    List<Furniture> furnitureList;
    private int furnitureID;

    public FurnitureServiceImpl() {
        furnitureList=new ArrayList<>();
        furnitureList.add(new Furniture(1,26.99F,"desk lamp","Carlsons"));
        furnitureList.add(new Furniture(2,20.99F,"End Table","Carlsons"));
        furnitureList.add(new Furniture(3,26.99F,"Chair","ChairCo"));
    }

    @Override
    public List<Furniture> getFurniture() {
        return furnitureList;
    }

    @Override
    public Furniture getFurnitureById(int furnitureID) {
        for(Furniture f:furnitureList)
        {
            if (f.getId()==furnitureID)
            {
                return f;
            }
        }
        return null;
    }

    @Override
    public Furniture addFurniture(Furniture furnitureToAdd) {
        furnitureList.add(furnitureToAdd);
        return furnitureToAdd;
    }

    @Override
    public Furniture updateFurniture(Furniture furnitureToUpdate) {
        String nameToUpdate=furnitureToUpdate.getName();
        String brandToUpdate=furnitureToUpdate.getBrand();
        for(Furniture f:furnitureList)
        {
            if (f.getId()==furnitureToUpdate.getId())
            {
                f.setName(nameToUpdate);
                f.setBrand(brandToUpdate);
                return f;
            }
        }
        return null;
    }

    @Override
    public void deleteFurniture(Furniture furnitureToDelete) {
        for(Furniture f:furnitureList)
        {
            if (f.getId()==furnitureToDelete.getId())
            {
                furnitureList.remove(f);
                System.out.println("deleted");
            }
        }
    }
}
