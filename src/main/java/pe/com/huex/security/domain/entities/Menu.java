package pe.com.huex.security.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "menu", indexes = {
        @Index(name = "menu_id_parent_id_child_key", columnList = "id_parent, id_child", unique = true)
})
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_parent", nullable = false)
    private Long idParent;

    @Column(name = "id_child", nullable = false)
    private Long idChild;

    @Column(name = "menu_label", nullable = false, length = 70)
    private String label;

    @Column(name = "menu_link", nullable = false, length = 300)
    private String link;

    @Column(name = "menu_status", nullable = false, length = 1)
    private String status;

    @Column(name = "menu_icon", nullable = false, length = 100)
    private String icon;

    @Column(name = "menu_update", nullable = false)
    private Boolean update = false;

    @Column(name = "menu_delete", nullable = false)
    private Boolean delete = false;

    @Column(name = "menu_create", nullable = false)
    private Boolean create = false;
}