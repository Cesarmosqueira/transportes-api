package pe.com.huex.security.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import pe.com.huex.security.service.dto.UserDetailsDto;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenProvider {

    private static String jwtSecret;
    private  static long jwtExpirationInMs;

    public JwtTokenProvider(@Value("${app.jwt.secret}") String jwtSecret, @Value("${app.jwt.expiration}") long jwtExpirationInMs) {
        this.jwtSecret = jwtSecret;
        this.jwtExpirationInMs = jwtExpirationInMs;
    }

    public static String generateToken(UserDetailsDto userDetailsDto) {
        Instant expiryDate = Instant.now().plusMillis(jwtExpirationInMs);
        Map<String, Object> dataAditional = new HashMap<>();
        dataAditional.put("status", userDetailsDto.getActive());

        return Jwts.builder()
                .setSubject(userDetailsDto.getUserName())
                .addClaims(dataAditional)
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(expiryDate))
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAutentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(jwtSecret.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String user = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }

    }

    public static long getExpiryDuration() {
        return jwtExpirationInMs;
    }
}
