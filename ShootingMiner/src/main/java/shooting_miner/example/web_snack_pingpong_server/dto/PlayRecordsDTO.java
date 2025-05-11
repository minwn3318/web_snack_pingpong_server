package shooting_miner.example.web_snack_pingpong_server.dto;

import java.time.LocalDateTime;
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
    private String game_id;
    private Integer stage;
    private Integer score;
    private LocalDateTime play_datetime;
}
