package shooting_miner.example.web_snack_pingpong_server.dao;

import shooting_miner.example.web_snack_pingpong_server.entity.UserIdEntity;

public interface UserIdDAO {
    UserIdEntity saveUserId(UserIdEntity userIdEntity);
    UserIdEntity loginUserId(String gameId);
}
