package shooting_miner.example.web_snack_pingpong_server.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shooting-miner")
public class LoginController {

    @PostMapping("/userids/login")
    public String login(@RequestBody String userId) {
        return userId;
    }

    @PostMapping("/userids/join")
    public String join(@RequestBody String userId) {
        return userId;
    }

    @GetMapping("/userids/logout")
    public String logout() {
        return "is-logout";
    }
}
