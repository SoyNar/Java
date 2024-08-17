package com.app.taskapplication.Controller;

import com.app.taskapplication.Entity.Task;
import com.app.taskapplication.Service.IServiceTask;

import com.app.taskapplication.Service.ServiceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TaskController {
    private static final Logger logger =
            LoggerFactory.getLogger(TaskController.class);
    @Autowired
    ServiceTask serviceTask;

//    indicamos la url que queremos procesas
    @GetMapping("/")
    public String start(ModelMap model){
        // recuperamos la lista de tareas
        List<Task> listTask = serviceTask.listTask();
        // imprimos a consola
        listTask.forEach((task) -> logger.info(task.toString()));
        model.put("listTask",listTask);
        return "index"; // redireccionar a la vista
    }

    @GetMapping("/add")
    public  String showAdd( ){
      return "addTask";
    }


}
