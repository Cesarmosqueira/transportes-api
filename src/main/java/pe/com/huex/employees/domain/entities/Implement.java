package pe.com.huex.employees.domain.entities;

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
	private Long id;

	@Column(nullable = false, length = 32)
	private String name;

	@Column(nullable = true, length = 1024)
	private String description;

	@Column(nullable = false)
	private boolean available;

	@OneToMany(mappedBy = "implement", cascade = CascadeType.ALL)
	private List<EmployeeImplement> employeeImplements = new ArrayList<>();
}
