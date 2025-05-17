package shooting_miner.example.web_snack_pingpong_server.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PlayRecordsDTO {
    @JsonProperty("game_id")
    private String gameId;

    @JsonProperty("stage")
    private Integer stage;

    @JsonProperty("score")
    private Integer score;

    @JsonProperty("play_datetime")
    private LocalDateTime playDatetime;
}
