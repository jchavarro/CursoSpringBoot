package gia.utp.primerproyecto.primerproyecto.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class LibroDTO {

    private Integer id;

    private String nombre;

    private String autor;

    private EditorialDTO editorial;

}
