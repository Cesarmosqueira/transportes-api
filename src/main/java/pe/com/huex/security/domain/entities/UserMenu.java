package pe.com.huex.security.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "user_menu", indexes = {
        @Index(name = "user_menu_id_user_id_parent_id_child_key", columnList = "id_user, id_parent, id_child", unique = true)
})
public class UserMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    @JsonIgnore
    private User user;

    @Column(name = "id_parent", nullable = false)
    private Long idParent;

    @Column(name = "id_child", nullable = false)
    private Long idChild;
}