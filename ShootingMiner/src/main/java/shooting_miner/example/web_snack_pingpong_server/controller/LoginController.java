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
import shooting_miner.example.web_snack_pingpong_server.dto.UserIdDTO;
import shooting_miner.example.web_snack_pingpong_server.service.AuthorizeService;
import shooting_miner.example.web_snack_pingpong_server.service.JoinAndLoginService;

@RestController
@RequestMapping("/shooting-miner")
public class LoginController {

    @Autowired
    JoinAndLoginService joinAndLoginService;

    @Autowired
    AuthorizeService authorizeService;
    
    @PostMapping("/userids/join")
    public ResponseEntity<UserIdDTO> join(@RequestBody UserIdDTO gameId,
    HttpServletRequest request ,HttpServletResponse response) {
        UserIdDTO result = joinAndLoginService.join(gameId);
        if ("EXISTS".equals(result.getGameId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PostMapping("/userids/login")
    public ResponseEntity<UserIdDTO> login(@RequestBody UserIdDTO gameId, 
    HttpServletRequest request ,HttpServletResponse response) {
        UserIdDTO result = joinAndLoginService.login(gameId);
        if ("NOT JOINED".equals(result.getGameId())) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
        result = authorizeService.createCookie(request, response, result);

        return ResponseEntity.ok(result);
    }

    @PostMapping("/userids/logout")
    public ResponseEntity<UserIdDTO> logout(HttpServletRequest request ,HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        UserIdDTO result = (UserIdDTO) session.getAttribute("userId");
        result = joinAndLoginService.logout(result);
        result = authorizeService.deleteCookie(request, response, result);
        return ResponseEntity.ok(result);
    }
}
