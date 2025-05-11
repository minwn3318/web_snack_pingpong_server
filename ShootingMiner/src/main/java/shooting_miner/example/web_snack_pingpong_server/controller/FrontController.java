package shooting_miner.example.web_snack_pingpong_server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shooting-miner")
public class FrontController {

    @PostMapping("/ranking")
    public String addRanking(@RequestBody String json) {
        return "Ranking added successfully" + json;
    }

    @GetMapping("/ranking/top-users") 
    public String getTopUsers(@RequestParam("total") List<Integer> totals) {
        return "Find top users";
    }
    
    @GetMapping("/ranking/{userId}/max-stage")
    public String getUserMaxStage(@PathVariable("userId") String userid) {
        return "find user max stage" + userid;
    }
    
    @GetMapping("/ranking/{userId}/max-score")
    public String getUserMaxScore(@PathVariable("userId") String userid) {
        return "find user max score" + userid;
    }

    @GetMapping("/ranking/{userId}/max-total")
    public String getUserMaxTotal(@PathVariable("userId") String userid) {
        return "find user max total" + userid;
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

    //        return "Record successfully inserted into PlayRecords.";
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //        return "Error: " + e.getMessage();
    //    }
    //}
}

