package gia.utp.primerproyecto.primerproyecto.service.implementations;

import gia.utp.primerproyecto.primerproyecto.model.entities.LibroEntity;
import gia.utp.primerproyecto.primerproyecto.model.repository.LibroRepository;
import gia.utp.primerproyecto.primerproyecto.service.interfaces.LibroService;
import gia.utp.primerproyecto.primerproyecto.service.interfaces.adapter.EditorialAdapter;
import gia.utp.primerproyecto.primerproyecto.web.dto.EditorialDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.LibroDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.response.LibroEditorialResponse;
import gia.utp.primerproyecto.primerproyecto.web.exceptions.types.BadRequestException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroServicioImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private EditorialAdapter editorialAdapter;

    @Transactional
    @Override
    public LibroDTO crearLibro(LibroDTO libroDTO) {
        if(libroDTO.getNombre().isEmpty())
            throw new BadRequestException("Los libros no pueden tener el nombre vacio");
        if(libroDTO.getEditorial().getId() == null) {
            EditorialDTO editorialDTO = editorialAdapter.crearEditorial(libroDTO.getEditorial());
            libroDTO.setEditorial(editorialDTO);
        }
        LibroEntity libroEntity = modelMapper.map(libroDTO, LibroEntity.class);
        libroEntity = libroRepository.save(libroEntity);
        return modelMapper.map(libroEntity, LibroDTO.class);
    }

    @Override
    public LibroDTO obtenerLibro(Integer id) {
        LibroEntity libroEntity = libroRepository.findById(id).get();
        return modelMapper.map(libroEntity, LibroDTO.class);
    }

    @Override
    public List<LibroEditorialResponse> obtenerLibrosPorEditorial(String edi) {
        List<LibroEntity> libroEntities = libroRepository.findAllByEditorial(edi)
                .orElseThrow(() -> new BadRequestException("No existen libros bajo esta editorial" + edi));
        List<LibroEditorialResponse> responseList = libroEntities.stream()
                .map(libroEntity -> modelMapper.map(libroEntity, LibroEditorialResponse.class))
                .collect(Collectors.toList());
        return responseList;
    }

    @Override
    public List<LibroDTO> obtenerLibroPorNombres(String nombreLibro, String nombreAutor) {
        return libroRepository.obtenerLibroPorNombres(nombreLibro, nombreAutor)
                .orElseThrow(() -> new BadRequestException("No existe un libro con los nombres relacionados"))
                .stream().map(libroEntity -> modelMapper.map(libroEntity, LibroDTO.class))
                .collect(Collectors.toList());
    }

}
