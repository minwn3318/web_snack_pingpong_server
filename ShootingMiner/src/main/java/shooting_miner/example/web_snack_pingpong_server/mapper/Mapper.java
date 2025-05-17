package shooting_miner.example.web_snack_pingpong_server.mapper;

import java.util.List;

import org.mapstruct.Mapping;

import shooting_miner.example.web_snack_pingpong_server.dto.PlayRecordCreateDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.TopPlayerRecordDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;

public interface Mapper {

    @Mapping(source="game_id", target="id.gameId")
    @Mapping(source="play_datetime", target="id.playDatetime")
    PlayRecordsEntity toEntity(PlayRecordCreateDTO dto);

    @Mapping(source="game_id", target="id.gameId")
    @Mapping(source="play_datetime", target="id.playDatetime")
    PlayRecordCreateDTO toPlayRecordCreateDTO(PlayRecordsEntity entity);

    @Mapping(source="game_id", target="id.gameId")
    TopPlayerRecordDTO toTopPlayerRecordDTO(PlayRecordsEntity entity);

    @Mapping(source="game_id", target="id.gameId")
    List<TopPlayerRecordDTO> toTopPlayerRecordDTOList(List<PlayRecordsEntity> entityList);
} 
