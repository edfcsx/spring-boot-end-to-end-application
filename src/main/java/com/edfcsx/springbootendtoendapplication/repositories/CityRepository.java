package com.edfcsx.springbootendtoendapplication.repositories;

import com.edfcsx.springbootendtoendapplication.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

}
