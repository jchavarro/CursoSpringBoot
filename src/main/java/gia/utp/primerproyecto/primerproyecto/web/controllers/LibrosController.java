package gia.utp.primerproyecto.primerproyecto.web.controllers;

import gia.utp.primerproyecto.primerproyecto.service.implementations.LibroServicioImpl;
import gia.utp.primerproyecto.primerproyecto.service.interfaces.LibroServicio;
import gia.utp.primerproyecto.primerproyecto.web.dto.LibroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("apiLibros/v1")
public class LibrosController {

    @Autowired
    private LibroServicio libroServicio;

    @PostMapping("crearLibro")
    public LibroDTO crearLibro(@RequestBody LibroDTO libroDTO) {
        return libroServicio.crearLibro(libroDTO);
    }

    /**
     * Motodo para obtener un libro.
     * @param id
     * @return
     */
    @GetMapping("obtenerLibro")
    public LibroDTO obtenerLibro(@RequestParam("id") Integer id) {
        return libroServicio.obtenerLibro(id);
    }

}
