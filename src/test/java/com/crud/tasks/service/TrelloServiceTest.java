package com.crud.tasks.service;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloServiceTest {

    @Autowired
    private TrelloService trelloService;

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testFetchTrelloBoards() {
        //Given
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloService.fetchTrelloBoards());
        //When
        int sizeResult = trelloBoard.size();
        //Then
        assertEquals(2,sizeResult);
    }
    
}