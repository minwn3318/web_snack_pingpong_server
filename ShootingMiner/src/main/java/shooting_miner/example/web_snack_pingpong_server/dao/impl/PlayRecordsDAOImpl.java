package shooting_miner.example.web_snack_pingpong_server.dao.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import shooting_miner.example.web_snack_pingpong_server.dao.PlayRecordsDAO;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntityPK;
import shooting_miner.example.web_snack_pingpong_server.repository.PlayRecordsRepository;

@Service
public class PlayRecordsDAOImpl implements PlayRecordsDAO{

    PlayRecordsRepository playRecordsRepository;

    public PlayRecordsDAOImpl(PlayRecordsRepository playRecordsRepository) {
        this.playRecordsRepository = playRecordsRepository;
    }

    @Override
    public PlayRecordsEntity savePlayRecord(PlayRecordsEntityPK playRecordPK, PlayRecordsEntity playRecord) {
        PlayRecordsEntity entity = new PlayRecordsEntity();
        entity.setPlayRecordPk(playRecordPK);
        entity.setScore(playRecord.getScore());
        entity.setStage(playRecord.getStage());

        playRecordsRepository.save(entity);

        return entity;
    }

    public List<PlayRecordsEntity> getTopUser(){
        PageRequest pageable = PageRequest.of(0, 3);
        List<PlayRecordsEntity> topUsers = playRecordsRepository.findTop3User(pageable);
        return topUsers;
    }

    public PlayRecordsEntity getMaxStage(String gameId){
        PlayRecordsEntity maxStage = playRecordsRepository.findMaxStageBygame_id(gameId);
        return maxStage;

    }

    public PlayRecordsEntity getMaxScore(String gameId){
        PlayRecordsEntity maxScore = playRecordsRepository.findMaxScoreBygame_id(gameId);
        return maxScore;
    }

    public PlayRecordsEntity getMaxTotal(String gameId){
        PlayRecordsEntity maxTotal = playRecordsRepository.findMaxTotalBygame_id(gameId);
        return maxTotal;
    }
}
