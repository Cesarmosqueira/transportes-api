package transportes.api.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "implement")
public class Implement {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 32)
	private String name;

	@Column(nullable = true, length = 512)
	private String description;

	@OneToMany(mappedBy = "implement", cascade = CascadeType.ALL)
	private List<EmployeeImplement> employeeImplements = new ArrayList<>();
}