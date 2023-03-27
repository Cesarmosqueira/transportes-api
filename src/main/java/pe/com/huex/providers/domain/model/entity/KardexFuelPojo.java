package pe.com.huex.providers.domain.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@NamedStoredProcedureQuery(
        name = "kardex.getAllKardexFuel",
        procedureName = "getAllKardexFuel",
        resultClasses = {KardexFuelPojo.class},
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, type = void.class)
        })
public class KardexFuelPojo {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tractPlate", nullable = false)
    private String tractPlate;

    @Column(name = "id_fuel_supply", nullable = false)
    private Long id_fuel_supply;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "amount_fuel", nullable = false)
    private Integer amountFuel;

    @Column(name = "mileage")
    private Long mileage;

    @Column(name = "duty_manager", length = 128)
    private String dutyManager;

    @Column(name = "operation", nullable = false, length = 1)
    private String operation;

    @Column(name = "unitPrice", nullable = false)
    private Double unitPrice;

    @Column(name = "balances", nullable = false)
    private Double balances;
}
