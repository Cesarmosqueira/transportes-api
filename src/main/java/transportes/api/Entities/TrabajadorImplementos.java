package transportes.api.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

// TODO: implementos and trabajador relation
@Entity
@Table(name = "trabajador_implementos")
public class TrabajadorImplementos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "trabajador_id")
	Trabajador trabajador;

	@ManyToOne
	@JoinColumn(name = "implemento_id")
	Implemento implemento;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fecha;

	@Column(nullable = true, length = 1024)
	private String observaciones;

};
