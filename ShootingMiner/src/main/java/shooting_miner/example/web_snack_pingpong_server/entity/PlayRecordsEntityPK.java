package shooting_miner.example.web_snack_pingpong_server.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Embeddable;

@Embeddable
public class PlayRecordsEntityPK {
    String game_id;
    LocalDateTime play_datetime;

    public void setGame_id(String game_id) {
        this.game_id = game_id;
    }   

    public void setPlay_datetime(LocalDateTime play_datetime) {
        this.play_datetime = play_datetime;
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
