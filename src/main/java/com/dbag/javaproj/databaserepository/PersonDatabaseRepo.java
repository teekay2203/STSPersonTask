package com.dbag.javaproj.databaserepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbag.javaproj.model.Person;

@Repository
public interface PersonDatabaseRepo extends JpaRepository<Person,Long>{
}
