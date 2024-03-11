package com.aditya.Repository;

import org.springframework.data.repository.CrudRepository;

import com.aditya.Model.Project;

public interface ProjectRepo extends CrudRepository<Project, Long> {

  boolean existsById(int id);

  void deleteById(int id);

}
