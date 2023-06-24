package gia.utp.primerproyecto.primerproyecto.service.interfaces;

import gia.utp.primerproyecto.primerproyecto.web.dto.LibroDTO;

public interface LibroServicio {

    LibroDTO crearLibro(LibroDTO libroDTO);

    LibroDTO obtenerLibro(Integer id);
}
