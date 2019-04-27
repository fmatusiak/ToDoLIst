package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class DbServiceTest {

    @Autowired
    private DbService dbService;

    private TaskMapper taskMapper;

    @Test
    public void testGetAllTasks() {
        //Given
        Task task = new Task(1L,"test","test");
        Task task2 = new Task(2L,"test2","test2");
        Task task3 = new Task(3L,"test3","test3");
        dbService.saveTask(task);
        dbService.saveTask(task2);
        dbService.saveTask(task3);
        //When
        int size = dbService.getAllTasks().size();
        //Then
        assertEquals(3,size);
    }

    @Test
    public void testGetTask() {
        //Given
        Task task = new Task(1L,"test","test");
        dbService.saveTask(task);
        //When
        Long id = dbService.getAllTasks().get(0).getId();
        Task taskRead = dbService.getTask(id).orElse(null);
        //Then
        assertEquals(task.getContent(),taskRead.getContent());
        assertEquals(task.getTitle(),taskRead.getTitle());
    }

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task(1L,"test","test");
        dbService.saveTask(task);
        //When
        int size = dbService.getAllTasks().size();
        //Then
        assertEquals(1,size);
    }

    @Test
    public void testDeleteTask() {
        //Given
        Task task = new Task(1L,"test","test");
        dbService.saveTask(task);
        //When
        int sizeListTasksBeforeDelete = dbService.getAllTasks().size();
        dbService.deleteTask(dbService.getAllTasks().get(0).getId());
        int sizeListTasksAfterDelete = dbService.getAllTasks().size();
        //Then
        assertEquals(1,sizeListTasksBeforeDelete);
        assertEquals(0,sizeListTasksAfterDelete);
    }

}