package gia.utp.primerproyecto.primerproyecto.web.controllers;

import gia.utp.primerproyecto.primerproyecto.service.interfaces.EditorialService;
import gia.utp.primerproyecto.primerproyecto.web.dto.EditorialDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.EditorialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("apiEditorial/v1")
public class EditorialController {

    @Autowired
    private EditorialService editorialService;

    @PostMapping("crearEditorial")
    public ResponseEntity<EditorialDTO> crearEditorial(@RequestBody EditorialDTO editorialDTO) {
        return new ResponseEntity<>(editorialService.crearEditorial(editorialDTO), HttpStatus.CREATED);
    }

    @GetMapping("obtenerEditorial")
    public ResponseEntity<EditorialResponse> obtenerEditorial(@RequestParam Integer id) {
        return new ResponseEntity<>(editorialService.obtenerEditorial(id), HttpStatus.FOUND);
    }
}
