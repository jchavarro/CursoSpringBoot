package gia.utp.primerproyecto.primerproyecto.service.interfaces;

import gia.utp.primerproyecto.primerproyecto.web.dto.EditorialDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.EditorialResponse;

public interface EditorialService {

    EditorialDTO crearEditorial(EditorialDTO editorialDTO);

    EditorialResponse obtenerEditorial(Integer id);

    EditorialDTO actualizarEitorial(EditorialDTO editorialDTO);

}
