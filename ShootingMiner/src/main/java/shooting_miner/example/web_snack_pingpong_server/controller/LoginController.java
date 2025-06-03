package shooting_miner.example.web_snack_pingpong_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shooting_miner.example.web_snack_pingpong_server.dto.PlayRecordCreateDTO;
import shooting_miner.example.web_snack_pingpong_server.dto.UserIdDTO;
import shooting_miner.example.web_snack_pingpong_server.service.AuthorizeService;
import shooting_miner.example.web_snack_pingpong_server.service.JoinAndLoginService;
import shooting_miner.example.web_snack_pingpong_server.service.RankRecordService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/shooting-miner")
public class LoginController {

    @Autowired
    JoinAndLoginService joinAndLoginService;

    @Autowired
    AuthorizeService authorizeService;

    @Autowired
    RankRecordService rankRecordService;
    
    @GetMapping("/hello")
    public String getMethodName() {
        String name = "Hello, this is Shooting Miner Server!";
        return name;
    }
    

    @PostMapping("/userids/join")
    public ResponseEntity<UserIdDTO> join(@RequestBody UserIdDTO gameId,
    HttpServletRequest request ,HttpServletResponse response) {
        UserIdDTO result = joinAndLoginService.join(gameId);
        if ("EXISTS".equals(result.getMessage())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        PlayRecordCreateDTO newRecord = new PlayRecordCreateDTO();
        newRecord.setGameId(result.getGameId());
        rankRecordService.serviceSavePlayRecord(newRecord, result);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/userids/login")
    public ResponseEntity<UserIdDTO> login(@RequestBody UserIdDTO gameId, 
    HttpServletRequest request ,HttpServletResponse response) {
        UserIdDTO result = joinAndLoginService.joinCheck(gameId);
        if ("NOT JOINED".equals(result.getMessage())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        result = authorizeService.checkAndCreateCookie(request, response, result);
        if( "LOGGED IN".equals(result.getMessage())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping("/userids/logout")
    public ResponseEntity<UserIdDTO> logout(HttpServletRequest request ,HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session == null) {
            UserIdDTO result = new UserIdDTO();
            result.setMessage("NOT LOGGED IN");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
        }
        String userid = (String) session.getAttribute("userId");
        UserIdDTO result = new UserIdDTO();
        result.setGameId(userid);
        
        result = joinAndLoginService.logout(result);
        result = authorizeService.deleteCookie(request, response, result);
        return ResponseEntity.ok(result);
    }
}
