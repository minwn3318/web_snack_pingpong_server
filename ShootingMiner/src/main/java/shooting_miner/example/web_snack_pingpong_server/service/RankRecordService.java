package shooting_miner.example.web_snack_pingpong_server.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shooting_miner.example.web_snack_pingpong_server.dao.impl.PlayRecordsDAOImpl;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayRecordCreateDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerScroeDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerStageDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerTotalDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.TopPlayerRecordDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.UserIdDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntityPK;
import shooting_miner.example.web_snack_pingpong_server.entity.UserIdEntity;
import shooting_miner.example.web_snack_pingpong_server.mapper.RecordsMapper;
import shooting_miner.example.web_snack_pingpong_server.mapper.UserIdsMapper;

@Service
public class RankRecordService {
    
    @Autowired
    UserIdsMapper userIdsMapper;
    @Autowired
    RecordsMapper recordsMapper;

    @Autowired
    PlayRecordsDAOImpl playRecordsDAO;

    public PlayRecordCreateDTO serviceSavePlayRecord(PlayRecordCreateDTO playRecordDTO, UserIdDTO userIdDTO) {
        if(playRecordDTO.getPlayDatetime() == null){
            playRecordDTO.setPlayDatetime(LocalDateTime.now());
            playRecordDTO.setStage(0);
            playRecordDTO.setScore(0);
        }
        playRecordDTO.setGameId(userIdDTO.getGameId());
        PlayRecordsEntity playRecordEntity = recordsMapper.toEntity(playRecordDTO);
        playRecordEntity = playRecordsDAO.savePlayRecord(playRecordEntity);
        PlayRecordCreateDTO resultDTO = recordsMapper.toPlayRecordCreateDTO(playRecordEntity);
        resultDTO.setGameId(null);
        return resultDTO;
    }
    public PlayerScroeDTO serviceGetMaxScore(UserIdDTO userId){
        UserIdEntity gameIdEntity = userIdsMapper.toUserIdEntity(userId);
        PlayRecordsEntity entity = playRecordsDAO.getMaxScore(gameIdEntity);
        PlayerScroeDTO resultDTO = recordsMapper.toPlayerScroeDTO(entity);
        resultDTO.setGameId(null); // 게임 ID는 클라이언트에 노출하지 않음
        return resultDTO;
    }

    public PlayerStageDTO serviceGetMaxStage(UserIdDTO userId){
        UserIdEntity gameIdEntity = userIdsMapper.toUserIdEntity(userId);
        PlayRecordsEntity entity = playRecordsDAO.getMaxStage(gameIdEntity);
        PlayerStageDTO resultDTO = recordsMapper.toPlayerStageDTO(entity);
        resultDTO.setGameId(null); // 게임 ID는 클라이언트에 노출하지 않음
        return resultDTO;
    }

    public PlayerTotalDTO serviceGetMaxTotal(UserIdDTO userId){
        UserIdEntity gameIdEntity = userIdsMapper.toUserIdEntity(userId);
        PlayRecordsEntity entity = playRecordsDAO.getMaxTotal(gameIdEntity);
        PlayerTotalDTO resultDTO = recordsMapper.toPlayerTotalDTO(entity);
        resultDTO.setGameId(null); // 게임 ID는 클라이언트에 노출하지 않음
        return resultDTO;
    }

    public List<TopPlayerRecordDTO> serviceGetTopUser(){
        List<PlayRecordsEntity> topUsers = playRecordsDAO.getTopUser();
        if(topUsers == null || topUsers.isEmpty() || topUsers.size() < 3) {
            topUsers = new ArrayList<>();
            for(int i = 0; i < 3; i++) {
                PlayRecordsEntity emptyRecord = new PlayRecordsEntity();
                emptyRecord.setPlayRecordPk(new PlayRecordsEntityPK("No User", LocalDateTime.now()));
                emptyRecord.setScore(0);
                emptyRecord.setStage(0);
                topUsers.add(emptyRecord);
            }
        }
        return recordsMapper.toTopPlayerRecordDTOList(topUsers);
    }
}
