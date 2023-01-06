package pe.com.huex.security.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MenuDto {
    private Long id;
    private Long idParent;
    private Long idChild;
    private String label;
    private String link;
    private String status;
    private String icon;
    private Boolean update;
    private Boolean delete;
    private Boolean create;
    private List<MenuDto> subItems;
}
