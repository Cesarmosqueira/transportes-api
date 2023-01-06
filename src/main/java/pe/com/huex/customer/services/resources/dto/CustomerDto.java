package pe.com.huex.customer.services.resources.dto;

import java.util.Date;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	private Long id;

	private String ruc;

	private String socialReason;

	private String bankAccount;

	private Date registerDate;

}
