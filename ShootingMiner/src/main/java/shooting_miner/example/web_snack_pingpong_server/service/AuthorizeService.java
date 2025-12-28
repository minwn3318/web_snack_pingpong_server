package shooting_miner.example.web_snack_pingpong_server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shooting_miner.example.web_snack_pingpong_server.componet.SessionManagerService;
import shooting_miner.example.web_snack_pingpong_server.dto.UserIdDTO;

@Service
public class AuthorizeService {

    @Autowired
    private SessionManagerService sessionManager;
    
    public UserIdDTO checkAndCreateCookie(
        HttpServletRequest request ,HttpServletResponse response, UserIdDTO result) {
        String gameId = result.getGameId();
        if(sessionManager.getSessionByGameId(gameId) == Boolean.TRUE) {
            result.setMessage("LOGGED IN");
            return result;  // 이미 존재하는 세션
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("userId", result.getGameId());
        sessionManager.registerSession(gameId, session);

        result.setMessage("LOG IN");

        return result;
    }

    public UserIdDTO deleteCookie(
        HttpServletRequest request ,HttpServletResponse response, UserIdDTO result) {
        
        HttpSession session = request.getSession(false);
        String sessiondUser = (String) session.getAttribute("userId");
        sessionManager.removeSession(sessiondUser);
        session.invalidate();  // 세션 무효화

        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0); // 즉시 만료
        response.addCookie(cookie);

        result.setMessage("LOG OUT");

        return result;
    }

    public UserIdDTO auth(HttpSession session){
        UserIdDTO userId = new UserIdDTO();
        userId.setGameId(null);
        userId.setMessage("NOT AUTHORIZED");
        if (session == null) {
            return userId;
        }
        String sessiondUser = (String) session.getAttribute("userId");
        if (sessiondUser == null) {
            return userId;
        }
        if(sessionManager.getSessionByGameId(sessiondUser) == Boolean.FALSE) {
            return userId;  // 세션이 존재하지 않음
        }
        userId.setGameId(sessiondUser);
        userId.setMessage("AUTHORIZED");
        return userId;
    }
}
