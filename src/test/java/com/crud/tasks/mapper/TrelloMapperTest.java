package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.service.TrelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoard() {
        //Given
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "test2", true));
        trelloLists.add(new TrelloListDto("2", "test3", false));

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "test", trelloLists);

        //Then
        TrelloBoard trelloBoardMap = trelloMapper.mapToBoard(trelloBoardDto);

        //When
        assertEquals(trelloBoardDto.getId(),trelloBoardMap.getId());
        assertEquals(trelloBoardDto.getName(),trelloBoardMap.getName());
        assertEquals(trelloBoardDto.getLists().size(),trelloBoardMap.getList().size());
    }

    @Test
    public void testMapToBoardDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "test2", true));
        trelloLists.add(new TrelloList("2", "test3", false));

        TrelloBoard trelloBoard = new TrelloBoard("1", "test", trelloLists);

        //Then
        TrelloBoardDto trelloBoardDtoMap = trelloMapper.mapToBoardDto(trelloBoard);

        //When
        assertEquals(trelloBoard.getId(),trelloBoardDtoMap.getId());
        assertEquals(trelloBoard.getName(),trelloBoardDtoMap.getName());
        assertEquals(trelloBoard.getList().size(),trelloBoardDtoMap.getLists().size());
    }

    @Test
    public void testMapToBoardsDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "test2", true));
        trelloLists.add(new TrelloList("2", "test3", false));

        TrelloBoard trelloBoard = new TrelloBoard("1", "test", trelloLists);
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "test2", trelloLists);
        TrelloBoard trelloBoard3 = new TrelloBoard("1", "test3", trelloLists);

        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);
        trelloBoards.add(trelloBoard2);
        trelloBoards.add(trelloBoard3);

        //When
        List<TrelloBoardDto> trelloBoardDtos = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(trelloBoards.size(),trelloBoardDtos.size());
    }

    @Test
    public void testMapToBoards() {
        //Given
        List<TrelloListDto> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloListDto("1", "test2", true));
        trelloLists.add(new TrelloListDto("2", "test3", false));

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "test", trelloLists);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "test2", trelloLists);
        TrelloBoardDto trelloBoardDto3 = new TrelloBoardDto("1", "test3", trelloLists);

        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto);
        trelloBoardsDto.add(trelloBoardDto2);
        trelloBoardsDto.add(trelloBoardDto3);

        //When
        List<TrelloBoard> trelloBoard = trelloMapper.mapToBoards(trelloBoardsDto);

        //Then
        assertEquals(trelloBoardsDto.size(),trelloBoard.size());
    }

    @Test
    public void  testMapToList(){
        //Given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("1", "test2", true));
        trelloListsDto.add(new TrelloListDto("2", "test3", false));

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListsDto);

        //Then
        for(int n = 0; n < trelloListsDto.size();n++){
            assertEquals(trelloListsDto.get(n).getId(),trelloLists.get(n).getId());
            assertEquals(trelloListsDto.get(n).getName(),trelloLists.get(n).getName());
            assertEquals(trelloListsDto.get(n).isClosed(),trelloLists.get(n).isClosed());
        }
        assertEquals(trelloListsDto.size(),trelloLists.size());
    }

    @Test
    public void  testMapToListDto(){
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("1", "test2", true));
        trelloLists.add(new TrelloList("2", "test3", false));

        //When
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(trelloLists);

        //Then
        for(int n = 0; n < trelloLists.size();n++){
            assertEquals(trelloLists.get(n).getId(),trelloListsDto.get(n).getId());
            assertEquals(trelloLists.get(n).getName(),trelloListsDto.get(n).getName());
            assertEquals(trelloLists.get(n).isClosed(),trelloListsDto.get(n).isClosed());
        }
        assertEquals(trelloLists.size(),trelloListsDto.size());
    }

    @Test
    public void testMapToCard(){
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("test","test","test","1");

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //When
        assertEquals(trelloCardDto.getDescription(),trelloCard.getDescription());
        assertEquals(trelloCardDto.getListId(),trelloCard.getListId());
        assertEquals(trelloCardDto.getName(),trelloCard.getName());
        assertEquals(trelloCardDto.getPos(),trelloCard.getPos());
    }

    @Test
    public void testMapToCardDto(){
        //Given
        TrelloCard trelloCard = new TrelloCard("test","test","test","1");

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //When
        assertEquals(trelloCard.getDescription(),trelloCardDto.getDescription());
        assertEquals(trelloCard.getListId(),trelloCardDto.getListId());
        assertEquals(trelloCard.getName(),trelloCardDto.getName());
        assertEquals(trelloCard.getPos(),trelloCardDto.getPos());
    }


}