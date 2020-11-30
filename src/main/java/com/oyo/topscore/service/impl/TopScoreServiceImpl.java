package com.oyo.topscore.service.impl;

import com.oyo.topscore.entities.PlayerDetail;
import com.oyo.topscore.repository.PlayerDetailRepository;
import com.oyo.topscore.service.TopScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class TopScoreServiceImpl implements TopScoreService {

    private static final Logger logger = LoggerFactory.getLogger(TopScoreServiceImpl.class);

    @Autowired
    PlayerDetailRepository playerDetailRepository;

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @return {@inheritDoc}
     */
    public String createScore(PlayerDetail playerDetail) {
        playerDetailRepository.save(playerDetail);
        return playerDetail.getId().toString();
        }

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @return {@inheritDoc}
     */
    public String getScore(Long id) {
        return String.valueOf(playerDetailRepository.findById(id).get().getScore());
    }

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @return {@inheritDoc}
     */
    public String deleteScore(Long id) {
        playerDetailRepository.delete(playerDetailRepository.getOne(id));
        return "Record with id: "+id+" is deleted";
    }

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @return {@inheritDoc}
     */
    public Page<Integer> getListOfScoresBeforeDateTime(String scoreCreatedBeforeDateTime, Pageable page) {
        return playerDetailRepository.findByStartDateBefore(LocalDateTime.parse(scoreCreatedBeforeDateTime), page);
    }

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @return {@inheritDoc}
     */
    public Page<Integer> getListOfScoresAfterDateTime(String scoreCreatedAfterDateTime, Pageable page) {
        return playerDetailRepository.findByStartDateAfter(LocalDateTime.parse(scoreCreatedAfterDateTime), page);
    }

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @return {@inheritDoc}
     */
    public Page<Integer> getListOfScoresForListOfPlayers(String[] listOfPlayers, Pageable page) {
        return playerDetailRepository.findByPlayerNameIn(listOfPlayers, page);
    }

    @Override
    public String getPlayerHistory(String playerName) {

        int sum = 0;
        float avg = 0;
        List<PlayerDetail> playerDetails = playerDetailRepository.findByPlayerName(playerName);
        PlayerDetail playerDetailMax =  Collections.max(playerDetails, Comparator.comparing(playerDetail -> playerDetail.getScore()));
        PlayerDetail playerDetailMin =  Collections.min(playerDetails, Comparator.comparing(playerDetail -> playerDetail.getScore()));

        List<String> playerScoreAndTime = new ArrayList<String>();
        for(int i=0;i<playerDetails.size();i++) {
            sum += playerDetails.get(i).getScore();
            playerScoreAndTime.add("Score:"+playerDetails.get(i).getScore() + " - Score Create Date Time: " + playerDetails.get(i).getScoreCreatedDateTime());
        }
        avg=sum/playerDetails.size();

        return "Player Name:" +playerName+"\n"+
                "Max Score is: "+playerDetailMax.getScore()+" Max Score Created Datetime is: "+playerDetailMax.getScoreCreatedDateTime()+"\n"+
                "Min Score is: "+playerDetailMin.getScore()+" Min Score Created Datetime is: "+playerDetailMin.getScoreCreatedDateTime()+"\n"+
                "Average Score is: "+avg+"\n"+
                "List of Score and Time"+playerScoreAndTime;
    }
}