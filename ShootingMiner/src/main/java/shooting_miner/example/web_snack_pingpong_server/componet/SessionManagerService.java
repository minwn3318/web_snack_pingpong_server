package shooting_miner.example.web_snack_pingpong_server.componet;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpSession;

@Component
public class SessionManagerService {
    private Map<String, HttpSession> sessionMap = new ConcurrentHashMap<>();

    public void registerSession(String gameId, HttpSession session) {
        sessionMap.put(gameId, session);
    }

    public boolean getSessionByGameId(String gameId) {
        System.out.println(sessionMap.get(gameId));
        if(sessionMap.get(gameId) != null) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void removeSession(String gameId) {
        sessionMap.remove(gameId);
    }    
}
