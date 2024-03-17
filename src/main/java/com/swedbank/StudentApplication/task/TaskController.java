package com.swedbank.StudentApplication.task;

import com.swedbank.StudentApplication.task.exceptiion.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/tasks")
public class TaskController {
     private final TaskService service;

    @Autowired
    public TaskController(TaskService service) {
        this.service = service;

    }


    @GetMapping
    public ResponseEntity <List<Task>> findAll(){
        List <Task> tasks = service.findAll();
        return new ResponseEntity<>(tasks,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity <Task> findById(@PathVariable("id") Long id)
            throws TaskNotFoundException{
        Task updatedTask = service.findById(id);
        return new ResponseEntity<Task>(updatedTask,HttpStatus.OK);
    }


    @PutMapping
    public ResponseEntity<Void> updateTask(@RequestBody Task task) {
        service.update(task);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping ("{id}")
    public  ResponseEntity <Void> deleteTask (@PathVariable final Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping
    public ResponseEntity<Void> deleteAllTasks (){
        service.deleteAll();
        return ResponseEntity.ok().build();
    }

}
