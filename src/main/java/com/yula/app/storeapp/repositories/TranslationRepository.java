package com.yula.app.storeapp.repositories;

import com.yula.app.storeapp.models.Translation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepository extends JpaRepository<Translation, Integer> {
}
