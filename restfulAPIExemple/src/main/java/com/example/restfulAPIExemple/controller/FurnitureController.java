package com.example.restfulAPIExemple.controller;

import com.example.restfulAPIExemple.Service.FurnitureService;
import com.example.restfulAPIExemple.entity.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FurnitureController {
@Autowired
    private FurnitureService furnitureService;

    @GetMapping("/")
    public String test()
    {
        return "<HTML><H1>hey what's up</H1></HTML>";
    }

    @GetMapping("/furniture")
    public List<Furniture> getFurniture()
    {

        return furnitureService.getFurniture();
    }
    @GetMapping("/furnitureByID/{furnitureID}")
    public Furniture getFurnitureById(@PathVariable String furnitureID)
    {

        return furnitureService.getFurnitureById(Integer.parseInt(furnitureID));
    }

    @PostMapping("/addFurniture")
    public Furniture addFurniture(@RequestBody Furniture furnitureToAdd)
    {
        return furnitureService.addFurniture(furnitureToAdd);
    }
    @PutMapping("/updateFurniture")
    public Furniture updateFurniture(@RequestBody Furniture furnitureToUpdate)
    {
        return furnitureService.updateFurniture(furnitureToUpdate);
    }
    @DeleteMapping("/deleteFurniture")
    public void deleteFurniture(@RequestBody Furniture furnitureToDelete)
    {
        furnitureService.deleteFurniture(furnitureToDelete.getId());
    }


}
