package shooting_miner.example.web_snack_pingpong_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayRecordCreateDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerScroeDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerStageDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayerTotalDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.TopPlayerRecordDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.UserIdDTO;
import shooting_miner.example.web_snack_pingpong_server.service.AuthorizeService;
import shooting_miner.example.web_snack_pingpong_server.service.RankRecordService;

@RestController
@RequestMapping("/shooting-miner")
public class RecordsController {

    @Autowired
    AuthorizeService authorizeService;

    @Autowired
    RankRecordService rankRecordService;

    @PostMapping("/play-records/save")
    public ResponseEntity<PlayRecordCreateDTO> setPlayRecords(
    @RequestBody PlayRecordCreateDTO newRecord, HttpServletRequest request ,HttpServletResponse response) throws JsonProcessingException {
        UserIdDTO result = authorizeService.auth(request.getSession());
        if ("NOT AUTHORIZED".equals(result.getGameId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(newRecord);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(rankRecordService.savePlayRecord(newRecord));
    }

    @GetMapping("/play-records/serach/top-users") 
    public ResponseEntity<List<TopPlayerRecordDTO>> getTopUsers() {
        return ResponseEntity.ok(rankRecordService.getTopUser());
    }
    
    @GetMapping("/play-records/serach/max-stage")
    public ResponseEntity<PlayerStageDTO> getUserMaxStage(
    HttpServletRequest request ,HttpServletResponse response) throws JsonProcessingException {
        UserIdDTO result = authorizeService.auth(request.getSession());
        if ("NOT AUTHORIZED".equals(result.getGameId())) {
            PlayerStageDTO newRecord = new PlayerStageDTO();
            newRecord.setMaxStage(null);
            newRecord.setGameId(null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(newRecord);
        }
        return ResponseEntity.ok(rankRecordService.getMaxStage(result));
    }
    
    @GetMapping("/play-records/serach/max-score")
    public ResponseEntity<PlayerScroeDTO> getUserMaxScore(
    HttpServletRequest request ,HttpServletResponse response)throws JsonProcessingException {
        UserIdDTO result = authorizeService.auth(request.getSession());
        if ("NOT AUTHORIZED".equals(result.getGameId())) {
            PlayerScroeDTO newRecord = new PlayerScroeDTO();
            newRecord.setMaxScore(null);
            newRecord.setGameId(null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(newRecord);
        }
        return ResponseEntity.ok(rankRecordService.getMaxScore(result));
    }

    @GetMapping("/play-records/serach/max-total")
    public ResponseEntity<PlayerTotalDTO> getUserMaxTotal(
    HttpServletRequest request ,HttpServletResponse response) throws JsonProcessingException {
        UserIdDTO result = authorizeService.auth(request.getSession());
        if ("NOT AUTHORIZED".equals(result.getGameId())) {
            PlayerTotalDTO newRecord = new PlayerTotalDTO();
            newRecord.setScore(null);
            newRecord.setStage(null);
            newRecord.setGameId(null);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(newRecord);
        }
        return ResponseEntity.ok(rankRecordService.getMaxTotal(result));
    }

}

