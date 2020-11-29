package com.oyo.topscore.controller;

import com.oyo.topscore.entities.PlayerDetail;
import com.oyo.topscore.service.TopScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TopScoreController {

    @Autowired
    TopScoreService topScoreService;

    @PostMapping("/create-score")
    public String createScore(@RequestBody PlayerDetail playerDetail){
        return topScoreService.createScore(playerDetail);
        }

    @GetMapping("/score/{id}")
    public String getScore(@PathVariable("id") Long id){
        return topScoreService.getScore(id);
    }

    @DeleteMapping("/score/{id}")
    public String deleteScore(@PathVariable("id") Long id){
        return topScoreService.deleteScore(id);
    }

    @GetMapping("/score/score-list")
    public List<Integer> getListOfScores(@RequestParam(name = "scoreCreatedBeforeDateTime", required = false) String scoreCreatedBeforeDateTime,
                                         @RequestParam(name = "scoreCreatedAfterDateTime", required = false)  String scoreCreatedAfterDateTime,
                                         @RequestParam(name = "listOfPlayers", required = false)  String[] listOfPlayers) {
        if (scoreCreatedBeforeDateTime!=null) {
            return topScoreService.getListOfScoresBeforeDateTime(scoreCreatedBeforeDateTime);
        } if(scoreCreatedAfterDateTime!=null){
            return topScoreService.getListOfScoresAfterDateTime(scoreCreatedAfterDateTime);
        } else {
            return topScoreService.getListOfScoresForListOfPlayers(listOfPlayers);
        }
    }
}
