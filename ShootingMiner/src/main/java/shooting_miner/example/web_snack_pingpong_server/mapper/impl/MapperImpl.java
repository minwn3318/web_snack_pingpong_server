package shooting_miner.example.web_snack_pingpong_server.mapper.impl;

import shooting_miner.example.web_snack_pingpong_server.mapper.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import shooting_miner.example.web_snack_pingpong_server.dto.PlayRecordsDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntityPK;   

@Service
public class MapperImpl implements Mapper {

    @Override
    public PlayRecordsEntity toEntity(PlayRecordsDTO dto) {
        if (dto == null) {
            return null;
        }

        PlayRecordsEntity entity = new PlayRecordsEntity();
        entity.setPlayRecordPk(new PlayRecordsEntityPK(dto.getGameId(), dto.getPlayDatetime()));
        entity.setScore(dto.getScore());
        entity.setStage(dto.getStage());

        return entity;
    }

    @Override
    public PlayRecordsDTO toDTO(PlayRecordsEntity entity) {
        if (entity == null) {
            return null;
        }

        PlayRecordsDTO dto = new PlayRecordsDTO();
        dto.setGameId(entity.getPlayRecordPk().getGameId());
        dto.setPlayDatetime(entity.getPlayRecordPk().getPlayDatetime());
        dto.setScore(entity.getScore());
        dto.setStage(entity.getStage());

        return dto;
    }

    @Override
    public List<PlayRecordsDTO> toDTOList(List<PlayRecordsEntity> entityList) {
        if (entityList == null) {
            return null;
        }

        List<PlayRecordsDTO> dtoList = new ArrayList<>();
        for (PlayRecordsEntity entity : entityList) {
            dtoList.add(toDTO(entity));
        }

        return dtoList;
    }
}
