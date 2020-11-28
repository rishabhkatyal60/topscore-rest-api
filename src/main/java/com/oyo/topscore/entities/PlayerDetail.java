package com.oyo.topscore.entities;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "PLAYER_DETAIL")
public class PlayerDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long id;

    @Column(name = "player_name")
    private String playerName;

    @Min(1)
    @Column(name = "score")
    private int score;

    @DateTimeFormat(iso= DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "score_created_datetime")
    private OffsetDateTime scoreCreatedDateTime;

}
