package shooting_miner.example.web_snack_pingpong_server.mapper.impl;

import shooting_miner.example.web_snack_pingpong_server.mapper.RecordsMapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import shooting_miner.example.web_snack_pingpong_server.dto.PlayRecordCreateDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.TopPlayerRecordDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntityPK;   

@Service
public class RecordsMapperImpl implements RecordsMapper {

    @Override
    public PlayRecordsEntity toEntity(PlayRecordCreateDTO dto) {
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
    public PlayRecordCreateDTO toPlayRecordCreateDTO(PlayRecordsEntity entity) {
        if (entity == null) {
            return null;
        }

        PlayRecordCreateDTO dto = new PlayRecordCreateDTO();
        dto.setGameId(entity.getPlayRecordPk().getGameId());
        dto.setPlayDatetime(entity.getPlayRecordPk().getPlayDatetime());
        dto.setScore(entity.getScore());
        dto.setStage(entity.getStage());

        return dto;
    }

    @Override
    public TopPlayerRecordDTO toTopPlayerRecordDTO(PlayRecordsEntity entity){
        if (entity == null) {
            return null;
        }

        TopPlayerRecordDTO dto = new TopPlayerRecordDTO();
        dto.setGameId(entity.getPlayRecordPk().getGameId());
        dto.setTopScore(entity.getScore());
        dto.setTopStage(entity.getStage());

        return dto;
    }


    @Override
    public List<TopPlayerRecordDTO> toTopPlayerRecordDTOList(List<PlayRecordsEntity> entityList) {
        if (entityList == null) {
            return null;
        }

        List<TopPlayerRecordDTO> dtoList = new ArrayList<>();
        for (PlayRecordsEntity entity : entityList) {
            dtoList.add(toTopPlayerRecordDTO(entity));
        }

        return dtoList;
    }
}
