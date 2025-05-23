package shooting_miner.example.web_snack_pingpong_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import shooting_miner.example.web_snack_pingpong_server.dao.impl.PlayRecordsDAOImpl;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayRecordCreateDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerScroeDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerStageDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerTotalDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.TopPlayerRecordDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.mapper.impl.MapperImpl;

@RestController
@RequestMapping("/shooting-miner")
public class FrontController {

    @Autowired
    private PlayRecordsDAOImpl playRecordsDAO;

    @Autowired
    private MapperImpl mapperImpl;

    @PostMapping("/play-records/save")
    public PlayRecordCreateDTO setPlayRecords(@RequestBody PlayRecordCreateDTO newRecord) throws JsonProcessingException {
        PlayRecordsEntity entity = mapperImpl.toEntity(newRecord);
        entity = playRecordsDAO.savePlayRecord(entity);
        PlayRecordCreateDTO resultDTO = mapperImpl.toPlayRecordCreateDTO(entity);
        return resultDTO;
    }

    @GetMapping("/play-records/serach/top-users") 
    public List<TopPlayerRecordDTO> getTopUsers() {
        List<PlayRecordsEntity> topUsers = playRecordsDAO.getTopUser();
        List<TopPlayerRecordDTO> resultDTO = mapperImpl.toTopPlayerRecordDTOList(topUsers);
        return resultDTO;
    }
    
    @GetMapping("/play-records/serach/max-stage")
    public PlayerStageDTO getUserMaxStage(@RequestParam("userId") String userid) throws JsonProcessingException {
        System.err.println("check : "+userid);
        PlayRecordsEntity entity = playRecordsDAO.getMaxStage(userid);
        return new PlayerStageDTO(entity.getStage());
    }
    
    @GetMapping("/play-records/serach/max-score")
    public PlayerScroeDTO getUserMaxScore(@RequestParam("userId") String userid)throws JsonProcessingException {
        PlayRecordsEntity entity = playRecordsDAO.getMaxScore(userid);
        return new PlayerScroeDTO(entity.getScore());
    }

    @GetMapping("/play-records/serach/max-total")
    public PlayerTotalDTO getUserMaxTotal(@RequestParam("userId") String userid) throws JsonProcessingException {
        PlayRecordsEntity entity = playRecordsDAO.getMaxTotal(userid);
        return new PlayerTotalDTO(entity.getStage(), entity.getScore());
    }

}

