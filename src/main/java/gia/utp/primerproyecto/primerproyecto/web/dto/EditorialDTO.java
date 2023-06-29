package gia.utp.primerproyecto.primerproyecto.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditorialDTO {

    private Integer id;

    private String nombreEditorial;

    private String direccion;

}
