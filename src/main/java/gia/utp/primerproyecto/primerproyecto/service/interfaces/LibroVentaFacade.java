package gia.utp.primerproyecto.primerproyecto.service.interfaces;

import gia.utp.primerproyecto.primerproyecto.web.dto.LibroDTO;

public interface LibroVentaFacade {

    LibroDTO venderLibro(Integer idLibro, Double precioLibro);

    LibroDTO devolverLibro(Integer idVenta);
}
