package org.example.repository;

import org.example.entity.Pojistenec;
import org.example.entity.Pojisteni;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PojistenecRepository extends JpaRepository<Pojistenec, Long> {
}
