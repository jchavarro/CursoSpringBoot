package gia.utp.primerproyecto.primerproyecto.service.implementations;

import gia.utp.primerproyecto.primerproyecto.model.entities.EditorialEntity;
import gia.utp.primerproyecto.primerproyecto.model.entities.LibroEntity;
import gia.utp.primerproyecto.primerproyecto.model.repository.LibroRepository;
import gia.utp.primerproyecto.primerproyecto.service.interfaces.adapter.EditorialAdapter;
import gia.utp.primerproyecto.primerproyecto.web.dto.EditorialDTO;
import gia.utp.primerproyecto.primerproyecto.web.dto.LibroDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class LibroServicioImplTest {

    @Mock
    private LibroRepository libroRepository;

    @Mock
    private ModelMapper modelMapper;

    @Mock
    private EditorialAdapter editorialAdapter;

    @InjectMocks
    private LibroServicioImpl libroServicio;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void crearLibro() {
        LibroDTO libroDTOEntrada = new LibroDTO(null, "Principito", "Anto",
                new EditorialDTO(null, "librosok", "carrera 4 # 21-20"));
        LibroDTO libroDTOEsperado = new LibroDTO(2, "Principito", "Anto",
                new EditorialDTO(1, "librosok", "carrera 4 # 21-20"));
        Mockito.when(editorialAdapter.crearEditorial(Mockito.any()))
                .thenReturn(new EditorialDTO(1, "librosok", "carrera 4 # 21-20"));
        Mockito.when(modelMapper.map(new LibroDTO(null, "Principito", "Anto",
                        new EditorialDTO(null, "librosok", "carrera 4 # 21-20")), LibroEntity.class))
                .thenReturn(new LibroEntity(null, "Principito", "Anto",
                new EditorialEntity(null, "librosok", "carrera 4 # 21-20")));
        Mockito.when(libroRepository.save(Mockito.any()))
                .thenReturn(new LibroEntity(2, "Principito", "Anto",
                        new EditorialEntity(1, "librosok", "carrera 4 # 21-20")));
        Mockito.when(modelMapper.map(new LibroEntity(2, "Principito", "Anto",
                        new EditorialEntity(1, "librosok", "carrera 4 # 21-20")), LibroDTO.class))
                .thenReturn(new LibroDTO(2, "Principito", "Anto",
                        new EditorialDTO(1, "librosok", "carrera 4 # 21-20")));

        LibroDTO libroDTOResultado = libroServicio.crearLibro(libroDTOEntrada);

        Assertions.assertEquals(libroDTOEsperado, libroDTOResultado);
        Mockito.verify(editorialAdapter).crearEditorial(Mockito.any());
        Mockito.verify(modelMapper).map(Mockito.any(), LibroEntity.class);
        Mockito.verify(libroRepository).save(Mockito.any());
        Mockito.verify(modelMapper).map(Mockito.any(), LibroDTO.class);
    }

    @Test
    void obtenerLibro() {
    }

    @Test
    void obtenerLibrosPorEditorial() {
    }

    @Test
    void obtenerLibroPorNombres() {
    }
}