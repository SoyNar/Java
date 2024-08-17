package com.app.taskapplication.Repository;

import com.app.taskapplication.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTask extends JpaRepository<Task,Long> {
}
