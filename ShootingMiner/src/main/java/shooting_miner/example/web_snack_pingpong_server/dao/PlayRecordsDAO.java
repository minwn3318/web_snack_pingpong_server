package shooting_miner.example.web_snack_pingpong_server.dao;

import java.util.List;

import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntityPK;

public interface PlayRecordsDAO {

    PlayRecordsEntity savePlayRecord(PlayRecordsEntityPK playRecordpk , PlayRecordsEntity playRecord);
    List<PlayRecordsEntity> getTopUser();
    PlayRecordsEntity getMaxStage(String gameId);
    PlayRecordsEntity getMaxScore(String gameId);
    PlayRecordsEntity getMaxTotal(String gameId);
}
