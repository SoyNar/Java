package com.project.registroEventos.Repository;

import com.project.registroEventos.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRepository extends JpaRepository<Events, String> {
}
