package com.oyo.topscore.service;

import com.oyo.topscore.entities.PlayerDetail;

public interface TopScoreService {

    /** create score. */
    public String createScore(PlayerDetail playerDetails);

    /** return score. */
    public String getScore(Long id);

    /** delete score. */
    public String deleteScore(Long id);
}
