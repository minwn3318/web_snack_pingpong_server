package shooting_miner.example.web_snack_pingpong_server.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shooting_miner.example.web_snack_pingpong_server.dao.UserIdDAO;
import shooting_miner.example.web_snack_pingpong_server.entity.UserIdEntity;
import shooting_miner.example.web_snack_pingpong_server.repository.UserIdsRepository;

@Service
public class UserIdDAOImpl implements UserIdDAO{

    @Autowired
    UserIdsRepository playRecordsRepository;
    
    @Override
    public UserIdEntity saveUserId(UserIdEntity userIdEntity) {
        playRecordsRepository.save(userIdEntity);
        return userIdEntity;
    }

    @Override
    public UserIdEntity checkUserId(UserIdEntity gameId) {
        String gameIdString = gameId.getGameId();
        UserIdEntity findingID = playRecordsRepository.findUserIdByGameId(gameIdString);
        if(findingID == null) {
            findingID = new UserIdEntity();
            findingID.setGameId(null);
        }
        return findingID;
    }
    
}
