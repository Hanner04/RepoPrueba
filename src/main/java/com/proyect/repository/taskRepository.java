package com.proyect.repository;

import com.proyect.model.itemTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface taskRepository  extends JpaRepository<itemTask, Long> {
}
