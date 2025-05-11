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
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import shooting_miner.example.web_snack_pingpong_server.dao.impl.PlayRecordsDAOImpl;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntity;
import shooting_miner.example.web_snack_pingpong_server.entity.PlayRecordsEntityPK;

@RestController
@RequestMapping("/shooting-miner")
public class FrontController {

    @Autowired
    private PlayRecordsDAOImpl playRecordsDAO;

    @PostMapping("/play-records")
    public String setPlayRecords(@RequestBody String json) throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        PlayRecordsEntity entity = objectMapper.readValue(json, PlayRecordsEntity.class);
        PlayRecordsEntityPK pk = entity.getPlayRecordpk();
        PlayRecordsEntity result = playRecordsDAO.savePlayRecord(pk, entity);
        String jsonResult = objectMapper.writeValueAsString(result);
        return "Record successfully inserted into play-records. \n" + jsonResult;
    }

    @GetMapping("/play-records/top-users") 
    public String getTopUsers() {
        List<PlayRecordsEntity> topUsers = playRecordsDAO.getTopUser();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String jsonResult = objectMapper.writeValueAsString(topUsers);
            return "Find Top Users. \n" +jsonResult;
        } catch (JsonProcessingException e) {
            return "Error: " + e.getMessage();
        }
    }
    
    @GetMapping("/play-records/{userId}/max-stage")
    public String getUserMaxStage(@PathVariable("userId") String userid) throws JsonProcessingException {
        PlayRecordsEntity result = playRecordsDAO.getMaxStage(userid);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult =  objectMapper.writeValueAsString(result);
        return "find user max stage. \n" + jsonResult;
    }
    
    @GetMapping("/play-records/{userId}/max-score")
    public String getUserMaxScore(@PathVariable("userId") String userid)throws JsonProcessingException {
        PlayRecordsEntity result = playRecordsDAO.getMaxScore(userid);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult =  objectMapper.writeValueAsString(result);
        return "find user max score. \n" + jsonResult;
    }

    @GetMapping("/play-records/{userId}/max-total")
    public String getUserMaxTotal(@PathVariable("userId") String userid) throws JsonProcessingException {
        PlayRecordsEntity result = playRecordsDAO.getMaxTotal(userid);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResult =  objectMapper.writeValueAsString(result);
        return "find user max total. \n" + jsonResult;
    }

    //@PostMapping(value = "/update-rank-tire")
    //public String UpdateRankTire(@RequestBody String json) {
    //    try {
            // JSON 문자열 파싱
    //        JSONObject jsonObject = new JSONObject(json);
    //        String gameId = jsonObject.getString("game_id");
            //int stage = jsonObject.getInt("stage");
            //int score = jsonObject.getInt("score");

    //        long userCount = jpainterface.countByGameId(gameId);

    //        if (userCount == 0) {
    //            return "Error: game_id does not exist in UserIDs table.";
    //        }

    //        return "Record successfully inserted into play-records.";
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //        return "Error: " + e.getMessage();
    //    }
    //}
}

