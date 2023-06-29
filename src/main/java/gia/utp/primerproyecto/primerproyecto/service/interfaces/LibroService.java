package gia.utp.primerproyecto.primerproyecto.service.interfaces;

import gia.utp.primerproyecto.primerproyecto.web.dto.LibroDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.LibroEditorialResponse;

import java.util.List;

public interface LibroService {

    LibroDTO crearLibro(LibroDTO libroDTO);

    LibroDTO obtenerLibro(Integer id);

    List<LibroEditorialResponse> obtenerLibrosPorEditorial(String edi);
}
