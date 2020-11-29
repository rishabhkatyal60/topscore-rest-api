package com.oyo.topscore.repository;

import com.oyo.topscore.entities.PlayerDetail;
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
    List<Integer> findByStartDateBefore(@Param("scoreCreatedDateTime") LocalDateTime scoreCreatedDateTime);

    @Query(value = "SELECT pd.score FROM PLAYER_DETAIL pd WHERE pd.score_created_datetime > ?1", nativeQuery = true)
    List<Integer> findByStartDateAfter(@Param("scoreCreatedDateTime") LocalDateTime scoreCreatedDateTime);

    @Query(value = "SELECT pd.score FROM PLAYER_DETAIL pd WHERE pd.player_name in ?1", nativeQuery = true)
    List<Integer> findByPlayerNameIn(@Param("listOfPlayers") String[] listOfPlayers);

}