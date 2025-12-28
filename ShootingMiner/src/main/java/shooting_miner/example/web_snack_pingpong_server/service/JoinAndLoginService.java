package shooting_miner.example.web_snack_pingpong_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shooting_miner.example.web_snack_pingpong_server.dao.impl.UserIdDAOImpl;
import shooting_miner.example.web_snack_pingpong_server.dto.UserIdDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.UserIdEntity;
import shooting_miner.example.web_snack_pingpong_server.mapper.impl.UserIdsMapperImpl;

@Service
public class JoinAndLoginService {
    @Autowired
    UserIdsMapperImpl userIdsMapper;

    @Autowired
    UserIdDAOImpl userIdDAO;

    public UserIdDTO join(UserIdDTO gameId) {
        UserIdEntity userIdEntity = userIdsMapper.toUserIdEntity(gameId);
        userIdEntity = userIdDAO.checkUserId(userIdEntity);
        if (userIdEntity.getGameId() == null) {
            userIdEntity.setGameId(gameId.getGameId());
            userIdEntity = userIdDAO.saveUserId(userIdEntity);
            gameId = userIdsMapper.toUserIdDTO(userIdEntity, "JOINED");
        }
        else {
            gameId.setMessage("EXISTS");
        }
        return gameId;
    }

    public UserIdDTO joinCheck(UserIdDTO gameId) {
        UserIdEntity userIdEntity = userIdsMapper.toUserIdEntity(gameId);
        userIdEntity = userIdDAO.checkUserId(userIdEntity);
        if (userIdEntity.getGameId() != null) {
            gameId = userIdsMapper.toUserIdDTO(userIdEntity, "JOINED IN");

        } else {
            gameId.setMessage("NOT JOINED");
        }
        return gameId;
    }

    public UserIdDTO logout(UserIdDTO gameId) {
        gameId.setMessage("LOGGED OUT");
        return gameId;
    }

}
