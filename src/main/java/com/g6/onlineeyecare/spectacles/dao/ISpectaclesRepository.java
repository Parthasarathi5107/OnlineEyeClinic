package com.g6.onlineeyecare.spectacles.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.g6.onlineeyecare.spectacles.dto.Spectacles;

@Repository
public interface ISpectaclesRepository extends JpaRepository<Spectacles, Integer>{

}
