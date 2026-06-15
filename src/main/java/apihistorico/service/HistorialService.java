package apihistorico.service;

import java.util.List;

import org.springframework.stereotype.Service;

import apihistorico.model.HistorialIncendios;
import apihistorico.repository.HistorialRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HistorialService {

    private final HistorialRepository repositorio;

    public List<HistorialIncendios> buscarHistorial() {
        return repositorio.findAll();
    }

    public String guardarHistorial(HistorialIncendios historial) {
        repositorio.save(historial);
        return "Historial guardado con id: " + historial.getId();
    }

    public String eliminarHistorial(Long id) {
        if (repositorio.findById(id).isPresent()) {
            repositorio.deleteById(id);
            return "Registro eliminado con id: " + id;
        }
        return "No existe registro con id: " + id;
    }

    public List<HistorialIncendios> buscarHistorialPorUsuario(String correo) {
        return repositorio.findByCorreoUsuario(correo);
    }
}