package gia.utp.primerproyecto.primerproyecto.service.implementations;

import gia.utp.primerproyecto.primerproyecto.model.entities.EditorialEntity;
import gia.utp.primerproyecto.primerproyecto.model.repository.EditorialRepository;
import gia.utp.primerproyecto.primerproyecto.service.interfaces.EditorialService;
import gia.utp.primerproyecto.primerproyecto.service.interfaces.adapter.EditorialAdapter;
import gia.utp.primerproyecto.primerproyecto.web.dto.EditorialDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.EditorialResponse;
import gia.utp.primerproyecto.primerproyecto.web.exceptions.types.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceImpl implements EditorialService, EditorialAdapter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EditorialRepository editorialRepository;

    @Override
    public EditorialDTO crearEditorial(EditorialDTO editorialDTO) {
        return modelMapper.map(editorialRepository.save(modelMapper
                .map(editorialDTO, EditorialEntity.class)), EditorialDTO.class);
    }

    @Override
    public EditorialResponse obtenerEditorial(Integer id) {
        EditorialEntity editorialEntity = editorialRepository.findById(id)
                .orElseThrow(() ->new BadRequestException("No se encontró editorial relacionada al id: " + id));
        return modelMapper.map(editorialEntity, EditorialResponse.class);
    }

    @Override
    public EditorialDTO actualizarEitorial(EditorialDTO editorialDTO) {
        return null;
    }
}
