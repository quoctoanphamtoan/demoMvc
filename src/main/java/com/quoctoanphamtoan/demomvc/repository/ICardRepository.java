package com.quoctoanphamtoan.demomvc.repository;

import com.quoctoanphamtoan.demomvc.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICardRepository extends JpaRepository<Card,Integer> {
}
