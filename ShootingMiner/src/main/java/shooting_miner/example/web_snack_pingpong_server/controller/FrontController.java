package shooting_miner.example.web_snack_pingpong_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import shooting_miner.example.web_snack_pingpong_server.dao.impl.PlayRecordsDAOImpl;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayRecordsDTO;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.mapper.impl.MapperImpl;

@RestController
@RequestMapping("/shooting-miner")
public class FrontController {

    @Autowired
    private PlayRecordsDAOImpl playRecordsDAO;

    @Autowired
    private MapperImpl mapperImpl;

    @PostMapping("/play-records")
    public PlayRecordsDTO setPlayRecords(@RequestBody PlayRecordsDTO newRecord) throws JsonProcessingException {
        PlayRecordsEntity entity = mapperImpl.toEntity(newRecord);
        entity = playRecordsDAO.savePlayRecord(entity);
        PlayRecordsDTO resultDTO = mapperImpl.toDTO(entity);
        return resultDTO;
    }

    @GetMapping("/play-records/top-users") 
    public List<PlayRecordsDTO> getTopUsers() {
        List<PlayRecordsEntity> topUsers = playRecordsDAO.getTopUser();
        List<PlayRecordsDTO> resultDTO = mapperImpl.toDTOList(topUsers);
        return resultDTO;
    }
    
    @GetMapping("/play-records/{userId}/max-stage")
    public PlayRecordsDTO getUserMaxStage(@PathVariable("userId") String userid) throws JsonProcessingException {
        PlayRecordsEntity entity = playRecordsDAO.getMaxStage(userid);
        PlayRecordsDTO resultDTO = mapperImpl.toDTO(entity);
        return resultDTO;
    }
    
    @GetMapping("/play-records/{userId}/max-score")
    public PlayRecordsDTO getUserMaxScore(@PathVariable("userId") String userid)throws JsonProcessingException {
        PlayRecordsEntity entity = playRecordsDAO.getMaxScore(userid);
        PlayRecordsDTO resultDTO = mapperImpl.toDTO(entity);
        return resultDTO;
    }

    @GetMapping("/play-records/{userId}/max-total")
    public PlayRecordsDTO getUserMaxTotal(@PathVariable("userId") String userid) throws JsonProcessingException {
        PlayRecordsEntity entity = playRecordsDAO.getMaxTotal(userid);
        PlayRecordsDTO resultDTO = mapperImpl.toDTO(entity);
        return resultDTO;
    }

}

