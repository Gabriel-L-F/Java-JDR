package com.example.demo.repositori;

import com.example.demo.model.Guerrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagicienRepository extends JpaRepository<Guerrier,Integer> {
}
