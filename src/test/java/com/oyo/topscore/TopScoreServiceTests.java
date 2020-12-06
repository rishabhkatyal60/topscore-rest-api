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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
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

    @Test
    public void getPlayerScoreByIdWithFailure() {
        PlayerDetail playerDetail = new PlayerDetail(100l,"Rishabh",80, LocalDateTime.parse("2018-11-21T11:13:13.274"));
        when(playerDetailRepository.findById(10l)).thenThrow(NoSuchElementException.class);
        String score;

        try{
            score = topScoreServiceImpl.getScore(10l);
        } catch (NoSuchElementException e) {
            score = "Score Id: "+10+" does not exist";
        }
        Assert.assertEquals("Score Id: 10 does not exist",score);
    }

    @Test
    public void getListOfScoresBeforeDateTime() {

        String scoreCreatedBeforeDateTime = "2018-12-21T11:13:13.274";
        int page = 0;
        int size = 3;
        Pageable paging = PageRequest.of(page, size);


        PlayerDetail playerDetail1 = new PlayerDetail(100l,"Rishabh1",80, LocalDateTime.parse("2018-11-21T11:13:13.274"));
        PlayerDetail playerDetail2 = new PlayerDetail(100l,"Rishabh2",90, LocalDateTime.parse("2018-10-21T11:13:13.274"));
        PlayerDetail playerDetail3  = new PlayerDetail(100l,"Rishabh3",100, LocalDateTime.parse("2018-09-21T11:13:13.274"));

        List<Integer> listOfScoresReturnedFromRepository = Arrays.asList(80, 90, 100);
        Page<Integer> pageListOfScoresReturnedFromRepository = new PageImpl<>(listOfScoresReturnedFromRepository);

        List<Integer> listOfScores = Arrays.asList(80, 90, 100);
        Page<Integer> expectedPageListOfScores = new PageImpl<>(listOfScores);

        when(playerDetailRepository.findByStartDateBefore(LocalDateTime.parse(scoreCreatedBeforeDateTime),paging)).thenReturn(pageListOfScoresReturnedFromRepository);
        Page<Integer>listOfScoresResponse = topScoreServiceImpl.getListOfScoresBeforeDateTime(scoreCreatedBeforeDateTime, paging);
        Assert.assertEquals(expectedPageListOfScores, pageListOfScoresReturnedFromRepository);
    }

    @Test
    public void getListOfScoresAfterDateTime() {

        String scoreCreatedBeforeDateTime = "2018-01-21T11:13:13.274";
        int page = 0;
        int size = 3;
        Pageable paging = PageRequest.of(page, size);


        PlayerDetail playerDetail1 = new PlayerDetail(100l,"Rishabh1",80, LocalDateTime.parse("2018-11-21T11:13:13.274"));
        PlayerDetail playerDetail2 = new PlayerDetail(100l,"Rishabh2",90, LocalDateTime.parse("2018-10-21T11:13:13.274"));
        PlayerDetail playerDetail3  = new PlayerDetail(100l,"Rishabh3",100, LocalDateTime.parse("2018-09-21T11:13:13.274"));

        List<Integer> listOfScoresReturnedFromRepository = Arrays.asList(80, 90, 100);
        Page<Integer> pageListOfScores = new PageImpl<>(listOfScoresReturnedFromRepository);

        List<Integer> listOfScores = Arrays.asList(80, 90, 100);
        Page<Integer> expectedPageListOfScores = new PageImpl<>(listOfScores);

        when(playerDetailRepository.findByStartDateBefore(LocalDateTime.parse(scoreCreatedBeforeDateTime),paging)).thenReturn(pageListOfScores);
        Page<Integer>listOfScoresResponse = topScoreServiceImpl.getListOfScoresAfterDateTime(scoreCreatedBeforeDateTime, paging);
        Assert.assertEquals(expectedPageListOfScores, pageListOfScores);
    }
}

