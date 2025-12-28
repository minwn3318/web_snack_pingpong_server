package shooting_miner.example.web_snack_pingpong_server.dao;

import java.util.List;

import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.entity.UserIdEntity;

public interface PlayRecordsDAO {

    PlayRecordsEntity savePlayRecord(PlayRecordsEntity playRecordEntity);
    List<PlayRecordsEntity> getTopUser();
    PlayRecordsEntity getMaxStage(UserIdEntity gameIdEntity);
    PlayRecordsEntity getMaxScore(UserIdEntity gameIdEntity);
    PlayRecordsEntity getMaxTotal(UserIdEntity gameIdEntity);
}
