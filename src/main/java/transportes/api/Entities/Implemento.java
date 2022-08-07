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
@Table(name = "implemento")
public class Implemento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 32)
	private String nombre;

	@Column(nullable = false)
	private Long cantidad;

	@Column(nullable = true, length = 128)
	private String descripcion;

	@OneToMany(mappedBy = "implemento", cascade = CascadeType.ALL)
	private List<TrabajadorImplementos> trabajadorImplementos = new ArrayList<>();
}
