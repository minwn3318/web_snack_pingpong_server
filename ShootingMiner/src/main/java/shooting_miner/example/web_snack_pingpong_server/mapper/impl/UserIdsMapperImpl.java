package shooting_miner.example.web_snack_pingpong_server.mapper.impl;

import org.springframework.stereotype.Service;
import shooting_miner.example.web_snack_pingpong_server.mapper.UserIdsMapper;

import shooting_miner.example.web_snack_pingpong_server.dto.UserIdDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.UserIdEntity;

@Service
public class UserIdsMapperImpl implements UserIdsMapper {

    @Override
    public UserIdEntity toUserIdEntity(UserIdDTO gameIdDTO) {
        if (gameIdDTO == null) {
            return null;
        }

        UserIdEntity entity = new UserIdEntity();
        entity.setGameId(gameIdDTO.getGameId());

        return entity;
    }

    @Override
    public UserIdDTO toUserIdDTO(UserIdEntity entity, String message) {
        if (entity == null) {
            return null;
        }

        UserIdDTO dto = new UserIdDTO();
        dto.setGameId(entity.getGameId());
        dto.setMessage(message);
        return dto;
    }
}
