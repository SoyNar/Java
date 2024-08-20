package com.app.taskapplication.Controller;

import com.app.taskapplication.Entity.Task;
import com.app.taskapplication.Service.IServiceTask;

import com.app.taskapplication.Service.ServiceTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
        model.put("listTask",listTask); // compartir informacion con nuestra presentacion
        return "index"; // redireccionar a la vista
    }

    // mostrar la pagina de agregar
    @GetMapping("/add")
    public  String showAdd( ){
      return "addTask";
    }

    // post
    // agregar una tarea
    // mapeando una peticion http post
    @PostMapping("/addT")
    public  String add(@ModelAttribute("taskForm") Task task){
        logger.info("task add " + task);
        serviceTask.saveTask(task);
        return "redirect:/";

    }
    // mostrar pagina update
    @GetMapping("/update/{id}")
    public String showUpdate(@PathVariable (value = "id")Long idTask,
                             ModelMap model){
         Task task = serviceTask.findTaskById(idTask);
         logger.info("task update :" + task);
         model.put("task", task);
         return "update";
    }

    // editar una tarea
    @PostMapping("/update")
    public String update(@ModelAttribute("task")  Task task){
        logger.info("task update" + task);
        serviceTask.saveTask(task);
        return "redirect:/"; // redirigimos al path de inicio
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(value = "id") Long id){
        Task task = new Task();
        task.setId(id);
        serviceTask.deleteTask(task);
        return "redirect:/";
    }

}
