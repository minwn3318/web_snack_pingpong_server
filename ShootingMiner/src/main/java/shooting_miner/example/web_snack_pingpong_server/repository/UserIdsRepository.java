package shooting_miner.example.web_snack_pingpong_server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shooting_miner.example.web_snack_pingpong_server.entity.UserIdEntity;

public interface UserIdsRepository extends JpaRepository<UserIdEntity, String> {
    @Query("SELECT p FROM UserIdEntity p WHERE p.gameId = :game_id")
    UserIdEntity findUserIdByGameId(@Param("game_id") String game_id);
}
