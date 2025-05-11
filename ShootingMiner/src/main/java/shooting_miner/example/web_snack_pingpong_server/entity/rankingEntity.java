package shooting_miner.example.web_snack_pingpong_server.entity;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@jakarta.persistence.Entity
@Builder
@Getter
@Setter
public class rankingEntity {
    @Id
    String gameId;
    Integer stage;
    Integer score;
}
