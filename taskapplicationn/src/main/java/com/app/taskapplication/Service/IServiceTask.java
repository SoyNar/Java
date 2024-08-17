package com.app.taskapplication.Service;

import com.app.taskapplication.Entity.Task;

import java.util.ArrayList;
import java.util.List;

public interface IServiceTask {
    public List<Task> listTask();

    public Task findTaskById(Long id);

    public void saveTask (Task task);

    public void deleteTask (Task task);


}
