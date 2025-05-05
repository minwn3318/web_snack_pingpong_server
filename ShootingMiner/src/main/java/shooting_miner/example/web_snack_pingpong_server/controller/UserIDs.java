package shooting_miner.example.web_snack_pingpong_server.controller;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "useridentity")
@Table(name = "userids")
public class UserIDs {

    @Id
    private String gameId;

    // Getters and Setters
    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }
}