package com.oyo.topscore.service.impl;

import com.oyo.topscore.TopScoreApplication;
import com.oyo.topscore.entities.PlayerDetail;
import com.oyo.topscore.repository.PlayerDetailRepository;
import com.oyo.topscore.service.TopScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
//        logger.info("Id is:",playerDetailRepository.findById(id).get().getId());
//        logger.info("Name is:",playerDetailRepository.findById(id).get().getPlayerName());
//        logger.info("Date is:",playerDetailRepository.findById(id).get().getScoreCreatedDateTime());
//        logger.info("Score is:",playerDetailRepository.findById(id).get().getScore());
        return String.valueOf(playerDetailRepository.findById(id).get().getScore());
    }
}