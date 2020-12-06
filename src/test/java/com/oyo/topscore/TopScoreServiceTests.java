package com.oyo.topscore;

import com.oyo.topscore.entities.PlayerDetail;
import com.oyo.topscore.repository.PlayerDetailRepository;
import com.oyo.topscore.service.impl.TopScoreServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TopScoreServiceTests {

    private static final Logger logger = LoggerFactory.getLogger(TopScoreServiceTests.class);

    @InjectMocks
    private TopScoreServiceImpl topScoreServiceImpl;

    @Mock
    private PlayerDetailRepository playerDetailRepository;

    @Test
    public void createNewScoreForThePlayer() {
        PlayerDetail playerDetail = new PlayerDetail("Rishabh",80, LocalDateTime.parse("2018-11-21T11:13:13.274"));
        PlayerDetail playerDetailResponseFromMockedRepository = new PlayerDetail(100l,"Rishabh",80, LocalDateTime.parse("2018-11-21T11:13:13.274"));
        when(playerDetailRepository.save(playerDetail)).thenReturn(playerDetailResponseFromMockedRepository);

        Assert.assertEquals(playerDetailResponseFromMockedRepository,topScoreServiceImpl.createScore(playerDetail));

    }

    @Test
    public void getPlayerScoreByIdWithSuccess() {
        PlayerDetail playerDetail = new PlayerDetail(100l,"Rishabh",80, LocalDateTime.parse("2018-11-21T11:13:13.274"));
        when(playerDetailRepository.findById(100l)).thenReturn(Optional.of(playerDetail));

        Assert.assertEquals("80",topScoreServiceImpl.getScore(100l));

    }
    
}

