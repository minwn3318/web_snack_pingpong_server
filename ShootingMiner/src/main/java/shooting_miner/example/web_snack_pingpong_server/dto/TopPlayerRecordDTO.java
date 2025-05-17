package shooting_miner.example.web_snack_pingpong_server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopPlayerRecordDTO {
    @JsonProperty("game_id")
    private String gameId;

    @JsonProperty("stage")
    private Integer stage;

    @JsonProperty("score")
    private Integer score;
}
