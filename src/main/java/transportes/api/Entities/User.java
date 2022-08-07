package transportes.api.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "_user")
public class User {
	@Id
	private int id;
	private String username;
	private String password;

}
