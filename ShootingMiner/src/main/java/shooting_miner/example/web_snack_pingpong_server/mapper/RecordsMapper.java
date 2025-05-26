package shooting_miner.example.web_snack_pingpong_server.mapper;

import java.util.List;

import org.mapstruct.Mapping;

import shooting_miner.example.web_snack_pingpong_server.dto.PlayRecordCreateDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerScroeDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerStageDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerTotalDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.TopPlayerRecordDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;

public interface RecordsMapper {

    @Mapping(source="game_id", target="id.gameId")
    @Mapping(source="play_datetime", target="id.playDatetime")
    PlayRecordsEntity toEntity(PlayRecordCreateDTO dto);

    @Mapping(source="game_id", target="id.gameId")
    @Mapping(source="play_datetime", target="id.playDatetime")
    PlayRecordCreateDTO toPlayRecordCreateDTO(PlayRecordsEntity entity);

    @Mapping(source="score", target = "id.score")
    @Mapping(source="game_id", target="id.gameId")
    PlayerScroeDTO toPlayerScroeDTO(PlayRecordsEntity entity);

    @Mapping(source="stage", target = "id.stage")
    @Mapping(source="game_id", target="id.gameId")
    PlayerStageDTO toPlayerStageDTO(PlayRecordsEntity entity);

    @Mapping(source="score", target = "id.score")
    @Mapping(source="stage", target = "id.stage")
    @Mapping(source="game_id", target="id.gameId")
    PlayerTotalDTO toPlayerTotalDTO(PlayRecordsEntity entity);

    @Mapping(source="game_id", target="id.gameId")
    TopPlayerRecordDTO toTopPlayerRecordDTO(PlayRecordsEntity entity);

    @Mapping(source="game_id", target="id.gameId")
    List<TopPlayerRecordDTO> toTopPlayerRecordDTOList(List<PlayRecordsEntity> entityList);
} 
