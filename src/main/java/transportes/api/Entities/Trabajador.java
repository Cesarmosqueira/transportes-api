package transportes.api.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "trabajador")
public class Trabajador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 64)
	private String nombreCompleto;

	@Column(nullable = false, length = 32)
	private String ubigeo;

	@Column(nullable = false, length = 32)
	private String tipoDocumento; // DNI o CE

	@Column(nullable = false, length = 16)
	private String documento; // DNI o CE

	@Column(nullable = false, length = 32)
	private String direccion;

	@Column(nullable = false, length = 16)
	private String telefono;

	@Column(nullable = false, length = 64)
	private String correo;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaIngreso;

	@Column(nullable = false, length = 32)
	private String estado;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaCese;

	@Column(nullable = false, length = 32)
	private String numCuenta;

	@Column(nullable = false, length = 32)
	private String tipoContrato;

	@Column(nullable = false, length = 16)
	private String estadoCivil;

	@Column(nullable = false, length = 16)
	private String sistemaPension;

	@Column(nullable = false)
	private int hijos;

	@Column(nullable = false, length = 32)
	private String nivelEstudios;

	@Column(nullable = false, length = 32)
	private String verificacionDomicilio;

	@Column(nullable = false, length = 32)
	private String penales;

	@Column(nullable = false, length = 32)
	private String parentesco;

	@Column(nullable = false, length = 32)
	private String nombreCompletoParentesco;

	@Column(nullable = false, length = 16)
	private String telefonoParentesco;

	@Column(nullable = false)
	private int sueldo;
}
