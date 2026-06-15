package apihistorico;

import apihistorico.model.HistorialIncendios;
import apihistorico.repository.HistorialRepository;
import apihistorico.service.HistorialService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class HistorialServiceTest {

    @Mock
    private HistorialRepository repositorio;

    @InjectMocks
    private HistorialService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void buscarHistorial_conRegistros_debeRetornarLista() {

        HistorialIncendios h1 = new HistorialIncendios();
        h1.setTipoIncendio("Forestal");
        h1.setNivelGravedad("ALTO");
        h1.setLatitud(-33.4489);
        h1.setLongitud(-70.6693);
        h1.setAreaAfectada(2.5);
        h1.setFechaInicio("2026-05-01T14:30:00");
        h1.setFechaCierre("2026-05-01T20:00:00");
        h1.setIdReporteOrigen(1L);

        HistorialIncendios h2 = new HistorialIncendios();
        h2.setTipoIncendio("Electrico");
        h2.setNivelGravedad("MEDIO");
        h2.setLatitud(-33.4500);
        h2.setLongitud(-70.6700);
        h2.setAreaAfectada(1.0);
        h2.setFechaInicio("2026-05-02T10:00:00");
        h2.setFechaCierre("2026-05-02T12:00:00");
        h2.setIdReporteOrigen(2L);

        when(repositorio.findAll())
                .thenReturn(Arrays.asList(h1, h2));

        List<HistorialIncendios> resultado = service.buscarHistorial();

        assertEquals(2, resultado.size(),
                "Deberia retornar 2 registros del historial");

        assertEquals("Forestal", resultado.get(0).getTipoIncendio(),
                "El primer registro deberia ser tipo Forestal");

        verify(repositorio, times(1)).findAll();
    }

    @Test
    void buscarHistorial_sinRegistros_debeRetornarListaVacia() {

        when(repositorio.findAll())
                .thenReturn(Arrays.asList());

        List<HistorialIncendios> resultado = service.buscarHistorial();

        assertNotNull(resultado,
                "La lista no deberia ser null aunque este vacia");

        assertEquals(0, resultado.size(),
                "La lista deberia estar vacia");

        verify(repositorio, times(1)).findAll();
    }

}