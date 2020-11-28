package com.oyo.topscore.repository;

import com.oyo.topscore.entities.PlayerDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDetailRepository extends JpaRepository<PlayerDetail, Long> {

}