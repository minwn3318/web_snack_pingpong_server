package shooting_miner.example.web_snack_pingpong_server.dao.impl;

import org.springframework.stereotype.Service;
import shooting_miner.example.web_snack_pingpong_server.dao.UserIdDAO;
import shooting_miner.example.web_snack_pingpong_server.entity.UserIdEntity;
import shooting_miner.example.web_snack_pingpong_server.repository.UserIdsRepository;

@Service
public class UserIdDAOImpl implements UserIdDAO{

    UserIdsRepository playRecordsRepository;
    public UserIdDAOImpl(UserIdsRepository playRecordsRepository) {
        this.playRecordsRepository = playRecordsRepository;
    }
    
    @Override
    public UserIdEntity saveUserId(UserIdEntity userIdEntity) {
        playRecordsRepository.save(userIdEntity);
        return userIdEntity;
    }

    @Override
    public UserIdEntity loginUserId(String gameId) {
        UserIdEntity findingID = playRecordsRepository.findUserIdByGameId(gameId);
        return findingID;
    }
    
}
