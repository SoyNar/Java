package com.app.taskapplication.Repository;

import com.app.taskapplication.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryTask extends JpaRepository<Task,Long> {
//    List<Task> findAllByNameContaining(String name);

}
