package transportes.api.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "proveedor")
public class Proveedor {
	@Id
	@Column(nullable = false, length = 16)
	private String RUC;

	@Column(nullable = false, length = 32)
	private String razonSocial;

	@Column(nullable = false, length = 32)
	private String contactoNombre;

	@Column(nullable = false, length = 16)
	private String telefono;

	@Column(nullable = false, length = 32)
	private String direccion;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaIngreso;
}
