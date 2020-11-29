package com.oyo.topscore.service.impl;

import com.oyo.topscore.entities.PlayerDetail;
import com.oyo.topscore.repository.PlayerDetailRepository;
import com.oyo.topscore.service.TopScoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
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
    public List<Integer> getListOfScoresBeforeDateTime(String scoreCreatedBeforeDateTime) {
        return playerDetailRepository.findByStartDateBefore(LocalDateTime.parse(scoreCreatedBeforeDateTime));
    }

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @return {@inheritDoc}
     */
    public List<Integer> getListOfScoresAfterDateTime(String scoreCreatedAfterDateTime) {
        return playerDetailRepository.findByStartDateAfter(LocalDateTime.parse(scoreCreatedAfterDateTime));
    }

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @return {@inheritDoc}
     */
    public List<Integer> getListOfScoresForListOfPlayers(String[] listOfPlayers) {
        return playerDetailRepository.findByPlayerNameIn(listOfPlayers);
    }
}