package com.oyo.topscore.controller;

import com.oyo.topscore.entities.PlayerDetail;
import com.oyo.topscore.service.TopScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
}
