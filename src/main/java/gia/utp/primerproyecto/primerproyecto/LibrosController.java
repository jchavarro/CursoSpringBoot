package gia.utp.primerproyecto.primerproyecto;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("apiLibros/v1")
public class LibrosController {

    private List<LibroDTO> libroDTOS;

    @PostMapping("crearLibro")
    public LibroDTO crearLibro(@RequestBody LibroDTO libroDTO) {

        libroDTOS.add(libroDTO);

        return libroDTOS.get(libroDTO.getId());
    }

    @GetMapping("obtenerLibro")
    public LibroDTO obtenerLibro(@RequestParam Integer id) {
        return libroDTOS.get(id);
    }

}
