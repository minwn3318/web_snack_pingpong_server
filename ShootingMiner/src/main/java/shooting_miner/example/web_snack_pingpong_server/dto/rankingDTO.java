package shooting_miner.example.web_snack_pingpong_server.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class rankingDTO {
    private String gameId;
    private Integer stage;
    private Integer score;
}
