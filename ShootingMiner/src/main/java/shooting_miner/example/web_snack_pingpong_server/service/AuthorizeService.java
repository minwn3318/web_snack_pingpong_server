package shooting_miner.example.web_snack_pingpong_server.service;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shooting_miner.example.web_snack_pingpong_server.dto.UserIdDTO;

@Service
public class AuthorizeService {

    public UserIdDTO createCookie(
        HttpServletRequest request ,HttpServletResponse response, UserIdDTO result) {
    
        HttpSession session = request.getSession(true);
        session.setAttribute("userId", result);

        Cookie jsid = new Cookie("JSESSIONID", session.getId());
        jsid.setPath("/");
        jsid.setMaxAge(7 * 24 * 60 * 60);  // 7일(초 단위)
        response.addCookie(jsid);

        return result;
    }

    public UserIdDTO deleteCookie(
        HttpServletRequest request ,HttpServletResponse response, UserIdDTO result) {
        
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();  // 세션 무효화
        }

        // JSESSIONID 쿠키 삭제
        Cookie cookie = new Cookie("JSESSIONID", null);
        cookie.setPath("/");         // 애플리케이션 전역에서 삭제
        cookie.setHttpOnly(true);    // 보안 옵션 권장
        cookie.setMaxAge(0);         // 즉시 만료
        response.addCookie(cookie);
        
        return result;
    }

    public UserIdDTO auth(HttpSession session){
        UserIdDTO userId = new UserIdDTO();
        userId.setGameId(null);
        userId.setMessage("NOT AUTHORIZED");
        if (session == null) {
            return userId;
        }
        userId = (UserIdDTO) session.getAttribute("userId");
        if (userId == null) {
            return userId;
        }
        userId.setMessage("AUTHORIZED");
        return userId;
    }
}
