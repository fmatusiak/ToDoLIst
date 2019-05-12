package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {

    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L,"test","test");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(taskDto.getId(),task.getId());
        assertEquals(taskDto.getTitle(),task.getTitle());
        assertEquals(taskDto.getContent(),task.getContent());
    }

    @Test
    public void mapToTaskDto() {
        //Given
        Task task = new Task(1L,"test","test");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(task.getId(),taskDto.getId());
        assertEquals(task.getTitle(),taskDto.getTitle());
        assertEquals(task.getContent(),taskDto.getContent());
    }

    @Test
    public void mapToTaskDtoList() {
        //Given
        Task task = new Task(1L,"test","test");
        Task task2 = new Task(2L,"test2","test2");
        Task task3 = new Task(3L,"test3","test3");

        List<Task> taskList = new ArrayList<>();
        taskList.add(task);
        taskList.add(task2);
        taskList.add(task3);

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertEquals(taskList.size(),taskDtos.size());
    }
}