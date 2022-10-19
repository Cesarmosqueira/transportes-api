package transportes.api.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "trabajador_oficina")
public class TrabajadorOficina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = true, length = 32)
	private String dCargo;

	@Column(nullable = true, length = 32)
	private String correo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "trabajador_id", referencedColumnName = "id")
	private Trabajador trabajador;
}
