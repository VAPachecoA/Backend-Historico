package apihistorico.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import apihistorico.model.HistorialIncendios;

public interface HistorialRepository extends JpaRepository<HistorialIncendios, Long> {

    List<HistorialIncendios> findByCorreoUsuario(String correoUsuario);

}
