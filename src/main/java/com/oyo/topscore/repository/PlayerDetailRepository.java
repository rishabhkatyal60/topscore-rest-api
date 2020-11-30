package com.oyo.topscore.repository;

import com.oyo.topscore.entities.PlayerDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PlayerDetailRepository extends JpaRepository<PlayerDetail, Long>,PagingAndSortingRepository<PlayerDetail, Long> {

    @Query(value = "SELECT pd.score FROM PLAYER_DETAIL pd WHERE pd.score_created_datetime < ?1", nativeQuery = true)
    Page<Integer> findByStartDateBefore(@Param("scoreCreatedDateTime") LocalDateTime scoreCreatedDateTime, Pageable page);

    @Query(value = "SELECT pd.score FROM PLAYER_DETAIL pd WHERE pd.score_created_datetime > ?1", nativeQuery = true)
    Page<Integer> findByStartDateAfter(@Param("scoreCreatedDateTime") LocalDateTime scoreCreatedDateTime, Pageable page);

    @Query(value = "SELECT pd.score FROM PLAYER_DETAIL pd WHERE pd.player_name in ?1", nativeQuery = true)
    Page<Integer> findByPlayerNameIn(@Param("listOfPlayers") String[] listOfPlayers, Pageable page);

    @Query(value = "SELECT * FROM PLAYER_DETAIL pd WHERE pd.player_name = ?1", nativeQuery = true)
    List<PlayerDetail> findByPlayerName(@Param("playerName") String playerName);

}