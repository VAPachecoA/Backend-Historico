package apihistorico.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import apihistorico.model.HistorialIncendios;
import apihistorico.service.HistorialService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/apihistorico")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class HistorialController {

    private final HistorialService service;

    @GetMapping("/historial")
    public List<HistorialIncendios> obtenerHistorial() {
        return service.buscarHistorial();
    }

    @PostMapping("/guardar")
    public String guardarHistorial(@Valid @RequestBody HistorialIncendios historial) {
        return service.guardarHistorial(historial);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarHistorial(@PathVariable Long id) {
        return service.eliminarHistorial(id);
    }

    @GetMapping("/historial/usuario/{correo}")
    public List<HistorialIncendios> obtenerPorUsuario(@PathVariable String correo) {
        return service.buscarHistorialPorUsuario(correo);
    }
}