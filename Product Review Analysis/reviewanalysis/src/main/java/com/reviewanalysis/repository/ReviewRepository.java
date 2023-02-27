package com.reviewanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reviewanalysis.entity.Reviews;

@Repository
public interface ReviewRepository extends JpaRepository<Reviews, Integer>, ReviewCustomRepository{

}
