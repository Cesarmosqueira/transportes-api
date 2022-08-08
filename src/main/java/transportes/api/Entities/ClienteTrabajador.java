package transportes.api.Entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente_Trabajador")
public class ClienteTrabajador {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@Column(nullable = false, length = 32)
	private String status;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaRegistro;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "chofer_id")
	private TrabajadorChofer chofer;

}
