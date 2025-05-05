package shooting_miner.example.web_snack_pingpong_server.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JPAinterface extends JpaRepository<UserIDs, String> {

    // Custom query to count game_id
    @Query("SELECT COUNT(u) FROM UserIDs u WHERE u.gameId = :gameId")
    long countByGameId(@Param("gameId") String gameId);
}
