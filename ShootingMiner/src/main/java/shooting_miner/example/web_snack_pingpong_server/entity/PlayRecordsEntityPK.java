package shooting_miner.example.web_snack_pingpong_server.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PlayRecordsEntityPK {
    @Column(name = "game_id")
    String gameId;
    @Column(name = "play_datetime")
    LocalDateTime playDatetime;

    public PlayRecordsEntityPK() {}

    public PlayRecordsEntityPK(String gameId, LocalDateTime playDatetime) {
        this.gameId = gameId;
        this.playDatetime = playDatetime;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String game_id) {
        this.gameId = game_id;
    }
    
    public LocalDateTime getPlayDatetime() {
        return playDatetime;
    }

    public void setPlayDatetime(LocalDateTime play_datetime) {
        this.playDatetime = play_datetime;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayRecordsEntityPK)) return false;
        PlayRecordsEntityPK that = (PlayRecordsEntityPK) o;
        return Objects.equals(gameId, that.gameId)
            && Objects.equals(playDatetime, that.playDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, playDatetime);
    }
}
