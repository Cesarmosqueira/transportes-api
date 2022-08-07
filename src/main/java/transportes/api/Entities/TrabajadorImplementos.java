package transportes.api.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: implementos and trabajador relation
@Entity
@Table(name = "trabajador_implementos")
public class TrabajadorImplementos {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

};
