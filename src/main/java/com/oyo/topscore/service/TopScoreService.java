package com.oyo.topscore.service;

import com.oyo.topscore.entities.PlayerDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.OffsetDateTime;
import java.util.List;

public interface TopScoreService {

    /** create score. */
    public String createScore(PlayerDetail playerDetails);

    /** return score. */
    public String getScore(Long id);

    /** delete score. */
    public String deleteScore(Long id);

    /** get list of scores before datetime */
    Page<Integer> getListOfScoresBeforeDateTime(String scoreCreatedBeforeDateTime, Pageable page);

    /** get list of scores after datetime */
    Page<Integer> getListOfScoresAfterDateTime(String scoreCreatedAfterDateTime, Pageable page);

    /** get list of scores by players name */
    Page<Integer> getListOfScoresForListOfPlayers(String[] listOfPlayers, Pageable page);

    /** get player history */
    public String getPlayerHistory(String playerName);
}
