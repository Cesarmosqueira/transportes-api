package pe.com.huex.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pe.com.huex.security.provider.JwtTokenProvider;
import pe.com.huex.security.service.dto.ResponseTokenDto;
import pe.com.huex.security.service.dto.UserDetailsDto;
import pe.com.huex.security.service.dto.UserDto;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        UserDto userDto = new UserDto();
        Authentication authentication = null;

        try {
            userDto = new ObjectMapper().readValue(request.getReader(), UserDto.class);
        } catch (IOException e) {

        }

        UsernamePasswordAuthenticationToken userNamePAT = new UsernamePasswordAuthenticationToken(
                userDto.getUserName(),
                userDto.getPassword(),
                Collections.emptyList()
        );

        authentication = getAuthenticationManager().authenticate(userNamePAT);

        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        UserDetailsDto userDetailsDto = (UserDetailsDto) authResult.getPrincipal();
        String token = JwtTokenProvider.generateToken(userDetailsDto);

        ResponseTokenDto responseTokenDto = new ResponseTokenDto();
        responseTokenDto.setAccessToken(token);
        responseTokenDto.setExpiryDuration(JwtTokenProvider.getExpiryDuration());
        UserDto userDto = new UserDto();
        userDto.setId(userDetailsDto.getUser().getId());
        userDto.setUserName(userDetailsDto.getUser().getUserName());
        userDto.setActive(userDetailsDto.getUser().getActive());
        responseTokenDto.setUser(userDto);
        ObjectMapper objectMapper= new ObjectMapper();
        String responseTokenDtoJson = objectMapper.writeValueAsString(responseTokenDto);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(responseTokenDtoJson);
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }
}
