package com.app.taskapplication.Service;

import com.app.taskapplication.Entity.Task;
import com.app.taskapplication.Repository.RepositoryTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTask implements  IServiceTask{

    // inyect dependences
@Autowired
    private RepositoryTask repositoryTask;

    @Override
    public List<Task> listTask() {
        return repositoryTask.findAll();
    }

    @Override
    public Task findTaskById(Long id) {
        Task task = repositoryTask.findById(id).orElse(null);
        return task;
    }

    @Override
    public void saveTask(Task task) {
        this.repositoryTask.save(task);

    }

    @Override
    public void deleteTask(Task task) {
        this.repositoryTask.delete(task);

    }
}
