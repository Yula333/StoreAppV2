package com.yula.app.storeapp.repositories;

import com.yula.app.storeapp.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
}
