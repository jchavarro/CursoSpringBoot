package gia.utp.primerproyecto.primerproyecto.web.dto.response;

import gia.utp.primerproyecto.primerproyecto.web.dto.LibroDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EditorialResponse {

    private Integer id;

    private String nombreEditorial;

    private String direccion;

    private List<LibroDTO> libroDTOS;

}
