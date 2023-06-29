package gia.utp.primerproyecto.primerproyecto.web.controllers;

import gia.utp.primerproyecto.primerproyecto.service.interfaces.LibroService;
import gia.utp.primerproyecto.primerproyecto.web.dto.LibroDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.LibroEditorialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private LibroService libroService;

    @PostMapping("crearLibro")
    public ResponseEntity<LibroDTO> crearLibro(@RequestBody LibroDTO libroDTO) {
        return new ResponseEntity<>(libroService.crearLibro(libroDTO), HttpStatus.CREATED);
    }

    /**
     * Motodo para obtener un libro.
     * @param id
     * @return
     */
    @GetMapping("obtenerLibro")
    public ResponseEntity<LibroDTO> obtenerLibro(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(libroService.obtenerLibro(id), HttpStatus.FOUND);
    }

    @GetMapping("obtenerLibrosPorEditorial")
    public ResponseEntity<List<LibroEditorialResponse>> obtenerLibrosPorEditorial(
            @RequestParam("editorial") String edi) {
        return new ResponseEntity<>(libroService.obtenerLibrosPorEditorial(edi), HttpStatus.FOUND);
    }

}
