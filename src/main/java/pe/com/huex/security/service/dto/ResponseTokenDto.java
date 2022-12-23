package pe.com.huex.security.service.dto;

import lombok.Data;

@Data

public class ResponseTokenDto {

    private String accessToken;

    private String refreshToken;

    private String tokenType;

    private Long expiryDuration;
}
