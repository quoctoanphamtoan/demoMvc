package com.quoctoanphamtoan.demomvc.repository;

import com.quoctoanphamtoan.demomvc.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<Person,Integer> {
}
