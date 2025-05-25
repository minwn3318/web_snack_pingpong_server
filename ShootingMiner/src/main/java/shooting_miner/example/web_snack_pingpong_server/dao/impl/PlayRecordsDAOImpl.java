package shooting_miner.example.web_snack_pingpong_server.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import shooting_miner.example.web_snack_pingpong_server.dao.PlayRecordsDAO;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.entity.UserIdEntity;
import shooting_miner.example.web_snack_pingpong_server.repository.PlayRecordsRepository;

@Service
public class PlayRecordsDAOImpl implements PlayRecordsDAO{

    @Autowired
    PlayRecordsRepository playRecordsRepository;

    @Override
    public PlayRecordsEntity savePlayRecord(PlayRecordsEntity playRecordEntity) {

        playRecordsRepository.save(playRecordEntity);

        return playRecordEntity;
    }

    public List<PlayRecordsEntity> getTopUser(){
        PageRequest pageable = PageRequest.of(0, 3);
        List<PlayRecordsEntity> topUsers = playRecordsRepository.findTop3User(pageable);
        return topUsers;
    }

    public PlayRecordsEntity getMaxStage(UserIdEntity gameIdEntity){
        String gameId = gameIdEntity.getGameId();
        PlayRecordsEntity maxStage = playRecordsRepository.findMaxStageBygame_id(gameId);
        return maxStage;

    }

    public PlayRecordsEntity getMaxScore(UserIdEntity gameIdEntity){
        String gameId = gameIdEntity.getGameId();
        PlayRecordsEntity maxScore = playRecordsRepository.findMaxScoreBygame_id(gameId);
        return maxScore;
    }

    public PlayRecordsEntity getMaxTotal(UserIdEntity gameIdEntity){
        String gameId = gameIdEntity.getGameId();
        PlayRecordsEntity maxTotal = playRecordsRepository.findMaxTotalBygame_id(gameId);
        return maxTotal;
    }
}
