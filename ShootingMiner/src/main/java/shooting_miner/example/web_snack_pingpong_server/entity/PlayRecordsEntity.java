package shooting_miner.example.web_snack_pingpong_server.entity;

import jakarta.persistence.EmbeddedId;
//import jakarta.persistence.Id;
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
@Table(name = "play_records")
public class PlayRecordsEntity {
    @EmbeddedId
    PlayRecordsEntityPK playRecordPk;
    Integer stage;
    Integer score;

    public PlayRecordsEntityPK getPlayRecordPk() {
        return playRecordPk;
    }

    public void setPlayRecordPk(PlayRecordsEntityPK playRecordpk) {
        this.playRecordPk = playRecordpk;
    }

    public Integer getStage() {
        return stage;
    }   
    
    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

}
