package shooting_miner.example.web_snack_pingpong_server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStageDTO {
    @JsonProperty("stage")
    private Integer maxStage;
}
