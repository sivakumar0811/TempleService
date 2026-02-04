package com.tutasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutasi.Model.SponsorTransactions;

@Repository
public interface SponsorTransactionsRepository extends JpaRepository<SponsorTransactions, Integer> {

}
