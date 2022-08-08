package transportes.api.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import transportes.api.Dto.Request.TrabajadorDtoRequest;

@Data
@Entity
@Table(name = "trabajador")
@NoArgsConstructor
public class Trabajador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	// Relations
	@OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TrabajadorAsistencia> asistencia = new ArrayList<>();

	@OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
	private List<TrabajadorImplementos> trabajadorImplementos = new ArrayList<>();

	@OneToMany(mappedBy = "trabajador", cascade = CascadeType.ALL)
	private List<TrabajadorDescuento> trabajadorDescuento = new ArrayList<>();

	@OneToOne(mappedBy = "trabajador", cascade = CascadeType.ALL)
	private TrabajadorOficina trabajadorOficina;

	@OneToOne(mappedBy = "trabajador", cascade = CascadeType.ALL)
	private TrabajadorChofer TrabajadorChofer;

	@OneToOne(mappedBy = "trabajador", cascade = CascadeType.ALL)
	private TrabajadorAuxiliar TrabajadoraAuxiliar;

	public Trabajador(TrabajadorDtoRequest trabajadorDto) {
		this.nombreCompleto = trabajadorDto.getNombreCompleto();
		this.ubigeo = trabajadorDto.getUbigeo();
		this.tipoDocumento = trabajadorDto.getTipoDocumento();
		this.documento = trabajadorDto.getDocumento();
		this.direccion = trabajadorDto.getDireccion();
		this.telefono = trabajadorDto.getTelefono();
		this.correo = trabajadorDto.getCorreo();
		this.fechaIngreso = trabajadorDto.getFechaIngreso();
		this.estado = trabajadorDto.getEstado();
		this.fechaCese = trabajadorDto.getFechaCese();
		this.numCuenta = trabajadorDto.getNumCuenta();
		this.tipoContrato = trabajadorDto.getTipoContrato();
		this.estadoCivil = trabajadorDto.getEstadoCivil();
		this.sistemaPension = trabajadorDto.getSistemaPension();
		this.hijos = trabajadorDto.getHijos();
		this.nivelEstudios = trabajadorDto.getNivelEstudios();
		this.verificacionDomicilio = trabajadorDto.getVerificacionDomicilio();
		this.penales = trabajadorDto.getPenales();
		this.parentesco = trabajadorDto.getParentesco();
		this.nombreCompletoParentesco = trabajadorDto.getNombreCompleto();
		this.telefonoParentesco = trabajadorDto.getTelefonoParentesco();
		this.sueldo = trabajadorDto.getSueldo();
	}
}
