package com.swedbank.StudentApplication.task;

import com.swedbank.StudentApplication.task.exceptiion.TaskExistsException;
import com.swedbank.StudentApplication.task.exceptiion.TaskNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository repository;

    @Autowired
    public TaskServiceImpl(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = repository.findAll();
        return tasks;
    }

    @Override
    public Task findById(long id) throws TaskNotFoundException {
        Task task = repository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        return task;
    }

    @Override
    public Task save(Task task) throws TaskExistsException {
        return repository.save(task);
    }

    @Override
    public void update(Task task) throws TaskNotFoundException {
        Task updatedTask = new Task();
        updatedTask.setShortDesc(task.getShortDesc());
        updatedTask.setDetails(task.getDetails());
        updatedTask.setStartDate(task.getStartDate());
        updatedTask.setEndDate(task.getEndDate());
        repository.save(updatedTask);
    }

    @Override
    public void delete(long id) throws TaskNotFoundException {
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new TaskNotFoundException(id);
        }
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
