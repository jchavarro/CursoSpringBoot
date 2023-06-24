package gia.utp.primerproyecto.primerproyecto.service.implementations;

import gia.utp.primerproyecto.primerproyecto.service.interfaces.LibroServicio;
import gia.utp.primerproyecto.primerproyecto.service.interfaces.LibroVentaFacade;
import gia.utp.primerproyecto.primerproyecto.web.dto.LibroDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LibroServicioImpl implements LibroServicio, LibroVentaFacade {

    private List<LibroDTO> libroDTOS;

    @Override
    public LibroDTO crearLibro(LibroDTO libroDTO) {
        libroDTOS.add(libroDTO);
        return libroDTOS.get(libroDTO.getId());
    }

    @Override
    public LibroDTO obtenerLibro(Integer id) {
        return null;
    }

    @Override
    public LibroDTO venderLibro(Integer idLibro, Double precioLibro) {
        return null;
    }

    @Override
    public LibroDTO devolverLibro(Integer idVenta) {
        return null;
    }
}
