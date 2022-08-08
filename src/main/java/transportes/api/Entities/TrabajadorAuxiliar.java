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
@Table(name = "trabajador_auxiliar")
public class TrabajadorAuxiliar {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = true, length = 32)
	private String Dcargo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "trabajador_id", referencedColumnName = "id")
	private Trabajador trabajador;

}
