package shooting_miner.example.web_snack_pingpong_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ReguestMapping("/shooting-miner")
public class FrontController {

    @Autowired
    private JPAinterface jpainterface;

    @GetMapping(value = "/max-rank-tire") 
    public MaxRankTireRecord ReadMaxRankTire(@RequestParam String userID) {
        String maxRank = "1";
        String maxScore = "1000";
        String maxStage = "10";

        MaxRankTireRecord returnMaxRankTireRecord = new MaxRankTireRecord(userID, maxRank, maxScore, maxStage);

        return returnMaxRankTireRecord;
    }
    
    @PostMapping(value = "/update-rank-tire")
    public String UpdateRankTire(@RequestBody String json) {
        try {
            // JSON 문자열 파싱
            JSONObject jsonObject = new JSONObject(json);
            String gameId = jsonObject.getString("game_id");
            //int stage = jsonObject.getInt("stage");
            //int score = jsonObject.getInt("score");

            long userCount = jpainterface.countByGameId(gameId);

            if (userCount == 0) {
                return "Error: game_id does not exist in UserIDs table.";
            }

            return "Record successfully inserted into PlayRecords.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }
}

