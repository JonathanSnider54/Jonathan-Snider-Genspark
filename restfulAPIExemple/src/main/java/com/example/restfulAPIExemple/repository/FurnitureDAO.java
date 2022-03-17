package com.example.restfulAPIExemple.repository;

import com.example.restfulAPIExemple.entity.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FurnitureDAO extends JpaRepository<Furniture, Integer> {
}
