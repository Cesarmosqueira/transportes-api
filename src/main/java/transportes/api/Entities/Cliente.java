package transportes.api.Entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 16)
	private String Ruc;
	
	@Column(nullable = false, length = 32)
	private String razonSocial;
	
	@Column(nullable = false, length = 32)
	private String cuenta;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date fechaRegistro;
	
	
	// Relations
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private List<ClienteTrabajador> clienteTrabajador = new ArrayList<>();
	

}
