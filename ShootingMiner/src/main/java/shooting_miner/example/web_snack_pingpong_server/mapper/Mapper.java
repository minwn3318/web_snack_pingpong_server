package shooting_miner.example.web_snack_pingpong_server.mapper;

import java.util.List;

import org.mapstruct.Mapping;

import shooting_miner.example.web_snack_pingpong_server.dto.PlayRecordsDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;

public interface Mapper {

    @Mapping(source="game_id", target="id.gameId")
    @Mapping(source="play_datetime", target="id.playDatetime")
    PlayRecordsEntity toEntity(PlayRecordsDTO dto);

    @Mapping(source="game_id", target="id.gameId")
    @Mapping(source="play_datetime", target="id.playDatetime")
    PlayRecordsDTO toDTO(PlayRecordsEntity entity);

    @Mapping(source="game_id", target="id.gameId")
    @Mapping(source="play_datetime", target="id.playDatetime")
    List<PlayRecordsDTO> toDTOList(List<PlayRecordsEntity> entityList);
} 
