package com.edfcsx.springbootendtoendapplication.repositories;

import com.edfcsx.springbootendtoendapplication.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

}
