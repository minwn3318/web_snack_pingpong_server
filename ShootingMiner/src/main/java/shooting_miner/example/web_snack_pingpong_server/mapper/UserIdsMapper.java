package shooting_miner.example.web_snack_pingpong_server.mapper;

import org.mapstruct.Mapping;

import shooting_miner.example.web_snack_pingpong_server.dto.UserIdDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.UserIdEntity;

public interface UserIdsMapper {

    @Mapping(source="game_id", target="id.gameId")
    UserIdEntity toUserIdEntity(UserIdDTO gameIdDTO);

    @Mapping(source="game_id", target="id.gameId")
    UserIdDTO toUserIdDTO(UserIdEntity entity, String message);
}
