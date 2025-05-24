package shooting_miner.example.web_snack_pingpong_server.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@jakarta.persistence.Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userids")
public class UserIdEntity {
    @Id
    @Column(name = "game_id")
    String gameId;

    public String getGameId() {
        return gameId;
    }   
    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}
