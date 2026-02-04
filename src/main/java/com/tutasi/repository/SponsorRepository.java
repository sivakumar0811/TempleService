package com.tutasi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tutasi.Model.SponsorData;
import com.tutasi.dto.Sponsor;

@Repository
public interface SponsorRepository extends JpaRepository<SponsorData, Integer>{

	SponsorData findBySponsorName(String name);

}
