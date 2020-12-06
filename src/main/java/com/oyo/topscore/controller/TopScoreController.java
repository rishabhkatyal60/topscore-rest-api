package com.oyo.topscore.controller;

import com.oyo.topscore.entities.PlayerDetail;
import com.oyo.topscore.service.TopScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
public class TopScoreController {

    @Autowired
    TopScoreService topScoreService;

    @PostMapping("/create-score")
    public PlayerDetail createScore(@RequestBody PlayerDetail playerDetail){
        return topScoreService.createScore(playerDetail);
        }

    @GetMapping("/score/{id}")
    public String getScore(@PathVariable("id") Long id){
        try{
            return topScoreService.getScore(id);
        } catch (NoSuchElementException e) {
            return "Score Id: "+id+" does not exist";
        }

    }

    @DeleteMapping("/score/{id}")
    public String deleteScore(@PathVariable("id") Long id){
        try{
            return topScoreService.deleteScore(id);
        } catch (NoSuchElementException e) {
            return "Record Id: "+id+" does not exist";
        }
    }

    @GetMapping("/score/score-list")
    public List<Integer> getListOfScores(@RequestParam(name = "scoreCreatedBeforeDateTime", required = false) String scoreCreatedBeforeDateTime,
                                         @RequestParam(name = "scoreCreatedAfterDateTime", required = false)  String scoreCreatedAfterDateTime,
                                         @RequestParam(name = "listOfPlayers", required = false)  String[] listOfPlayers,
                                         @RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "3") int size) {

        Pageable paging = PageRequest.of(page, size);
        Page<Integer> pagedResult = null;
        if (scoreCreatedBeforeDateTime!=null) {
            pagedResult = topScoreService.getListOfScoresBeforeDateTime(scoreCreatedBeforeDateTime, paging);
            return pagedResult.getContent();
        } if(scoreCreatedAfterDateTime!=null){
            pagedResult = topScoreService.getListOfScoresAfterDateTime(scoreCreatedAfterDateTime, paging);
            return pagedResult.getContent();
        } else {
            String listOfPlayersToLowerCase[]=new String[listOfPlayers.length];
            for (int i = 0; i < listOfPlayers.length; i++)
            {
                listOfPlayersToLowerCase[i]=listOfPlayers[i].toLowerCase();
            }
            pagedResult = topScoreService.getListOfScoresForListOfPlayers(listOfPlayersToLowerCase, paging);
            return pagedResult.getContent();
        }
    }

    @GetMapping("/player-history/{playerName}")
    public String getPlayerHistory(@PathVariable("playerName") String playerName){
        try{
            return topScoreService.getPlayerHistory(playerName.toLowerCase());
        } catch(NoSuchElementException e) {
            return "Player Name: "+playerName+ " Not found";
        }

    }
}
