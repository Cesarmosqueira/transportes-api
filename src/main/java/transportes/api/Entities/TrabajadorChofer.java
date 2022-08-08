package transportes.api.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "trabajador_chofer")
public class TrabajadorChofer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "trabajador_id")
	private Trabajador trabajador;
	
	@Column(nullable = true, length = 32)
	private String Dcategoria;
	
	@Column(nullable = true, length = 32)
	private String Dcargo;
	
	
	// Relations
	@OneToMany(mappedBy = "trabajadorChofer", cascade = CascadeType.ALL)
	private List<ClienteTrabajador> clienteTrabajador = new ArrayList<>();

}
