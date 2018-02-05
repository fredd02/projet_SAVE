package com.save.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.save.model.Location;

public interface ILocationRepository extends JpaRepository<Location, Long>{

}
