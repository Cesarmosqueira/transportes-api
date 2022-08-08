package transportes.api.Dto.Response;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import transportes.api.Entities.Trabajador;

@Data
@NoArgsConstructor
public class TrabajadorDtoResponse {
	private Long id;

	private String nombreCompleto;

	private String ubigeo;

	private String tipoDocumento; // DNI o CE

	private String documento; // DNI o CE

	private String direccion;

	private String telefono;

	private String correo;

	private Date fechaIngreso;

	private String estado;

	private Date fechaCese;

	private String numCuenta;

	private String tipoContrato;

	private String estadoCivil;

	private String sistemaPension;

	private int hijos;

	private String nivelEstudios;

	private String verificacionDomicilio;

	private String penales;

	private String parentesco;

	private String nombreCompletoParentesco;

	private String telefonoParentesco;

	private int sueldo;

	public TrabajadorDtoResponse(Trabajador trabajador) {
		this.id = trabajador.getId();
		this.nombreCompleto = trabajador.getNombreCompleto();
		this.ubigeo = trabajador.getUbigeo();
		this.tipoDocumento = trabajador.getTipoDocumento();
		this.documento = trabajador.getDocumento();
		this.direccion = trabajador.getDireccion();
		this.telefono = trabajador.getTelefono();
		this.correo = trabajador.getCorreo();
		this.fechaIngreso = trabajador.getFechaIngreso();
		this.estado = trabajador.getEstado();
		this.fechaCese = trabajador.getFechaCese();
		this.numCuenta = trabajador.getNumCuenta();
		this.tipoContrato = trabajador.getTipoContrato();
		this.estadoCivil = trabajador.getEstadoCivil();
		this.sistemaPension = trabajador.getSistemaPension();
		this.hijos = trabajador.getHijos();
		this.nivelEstudios = trabajador.getNivelEstudios();
		this.verificacionDomicilio = trabajador.getVerificacionDomicilio();
		this.penales = trabajador.getPenales();
		this.parentesco = trabajador.getParentesco();
		this.nombreCompletoParentesco = trabajador.getNombreCompleto();
		this.telefonoParentesco = trabajador.getTelefonoParentesco();
		this.sueldo = trabajador.getSueldo();
	}
}
