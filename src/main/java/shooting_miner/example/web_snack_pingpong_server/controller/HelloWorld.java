package shooting_miner.example.web_snack_pingpong_server.controller;


import org.springframework.web.bind.annotation.GetMapping;
// org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("hello") 
    public String hello() {
        return "Hello World!";
    }   
}
