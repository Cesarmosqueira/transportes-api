package pe.com.huex.security.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import pe.com.huex.employees.domain.entities.Employee;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "users", indexes = {
        @Index(name = "users_user_name_key", columnList = "user_name", unique = true)
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false, length = 15)
    private String userName;

    @ManyToOne
    @JoinColumn(name = "id_employee", nullable = false)
    @JsonIgnore
    private Employee employee;

    @Column(name = "password", nullable = false)
    @Type(type = "org.hibernate.type.TextType")
    private String password;

    @Column(name = "active", nullable = false)
    private Boolean active = false;
}