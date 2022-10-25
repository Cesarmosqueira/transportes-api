package pe.com.huex.entities;

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
@Table(name = "client")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, length = 16)
	private String ruc;

	@Column(nullable = false, length = 32)
	private String socialReason;

	@Column(nullable = false, length = 32)
	private String bankAccount;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date registerDate;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<ClientEmployee> employees = new ArrayList<>();
}
