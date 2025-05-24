package shooting_miner.example.web_snack_pingpong_server.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntityPK;

public interface PlayRecordsRepository extends JpaRepository<PlayRecordsEntity, PlayRecordsEntityPK> {

    @Query("SELECT p FROM PlayRecordsEntity p WHERE p.playRecordPk.gameId = :game_id AND p.stage = (SELECT MAX(p2.stage) FROM PlayRecordsEntity p2 WHERE p2.playRecordPk.gameId = :game_id)")
    PlayRecordsEntity findMaxStageBygame_id(@Param("game_id") String game_id);
    
    @Query("SELECT p FROM PlayRecordsEntity p WHERE p.playRecordPk.gameId = :game_id AND p.score =  (SELECT MAX(p2.score) FROM PlayRecordsEntity p2 WHERE p2.playRecordPk.gameId = :game_id)")
    PlayRecordsEntity findMaxScoreBygame_id(@Param("game_id") String game_id);

    @Query("SELECT p FROM PlayRecordsEntity p WHERE p.playRecordPk.gameId = :game_id AND (p.score + p.stage * 100) = (SELECT MAX(p2.score + p2.stage * 100) FROM PlayRecordsEntity p2 WHERE p2.playRecordPk.gameId = :game_id)")
    PlayRecordsEntity findMaxTotalBygame_id(@Param("game_id") String game_id);

    @Query("SELECT p FROM PlayRecordsEntity p ORDER BY (p.score + p.stage * 100) DESC")
    List<PlayRecordsEntity> findTop3User(PageRequest pageable);
}
