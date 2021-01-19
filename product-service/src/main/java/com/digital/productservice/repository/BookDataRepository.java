package com.digital.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digital.productservice.entity.BookData;

@Repository
public interface BookDataRepository extends JpaRepository<BookData, Integer>{

}
