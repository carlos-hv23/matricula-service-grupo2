package pe.edu.cibertec.matriculaservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import pe.edu.cibertec.matriculaservice.dto.MatriculaResponseDTO;
import pe.edu.cibertec.matriculaservice.service.MatriculaService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/matriculas")
public class MatriculaController {

    private final MatriculaService matriculaService;


    @GetMapping("/{idMatricula}")
    public ResponseEntity<MatriculaResponseDTO> obtenerMatricula(@PathVariable Long idMatricula) {
        return ResponseEntity.ok(matriculaService.obtenerMatricula(idMatricula));
    }
}
