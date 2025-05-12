package shooting_miner.example.web_snack_pingpong_server.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class PlayRecordsEntityPK {
    @Column(name = "game_id")
    String gameId;
    @Column(name = "play_datetime")
    LocalDateTime playDatetime;

    public PlayRecordsEntityPK() {}

    public String getGame_id() {
        return gameId;
    }

    // public LocalDateTime getPlay_datetime() {
    //     return playDatetime;
    // }

    public void setGame_id(String game_id) {
        this.gameId = game_id;
    }   

    public void setPlay_datetime(LocalDateTime play_datetime) {
        this.playDatetime = play_datetime;
    }
    
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
