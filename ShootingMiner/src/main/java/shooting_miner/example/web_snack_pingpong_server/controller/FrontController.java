package shooting_miner.example.web_snack_pingpong_server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ReguestMapping("/shooting-miner")
public class FrontController {

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

        Integer num = 0;
        boolean condition = true;
        do {
            for ( int i = 0; i < 10; i++) {
                num += 1;
            }
            condition = false;
        } while (condition);
 
        return Integer.toString(num);  

    }
}

