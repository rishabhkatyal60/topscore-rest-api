package com.oyo.topscore.service;

import com.oyo.topscore.entities.PlayerDetail;

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
    List<Integer> getListOfScoresBeforeDateTime(String scoreCreatedBeforeDateTime);

    /** get list of scores after datetime */
    List<Integer> getListOfScoresAfterDateTime(String scoreCreatedAfterDateTime);

    /** get list of scores by players name */
    List<Integer> getListOfScoresForListOfPlayers(String[] listOfPlayers);
}
