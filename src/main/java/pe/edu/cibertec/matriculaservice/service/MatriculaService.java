package pe.edu.cibertec.matriculaservice.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import lombok.RequiredArgsConstructor;
import pe.edu.cibertec.matriculaservice.dto.DetalleCursoMatriculadoDTO;
import pe.edu.cibertec.matriculaservice.dto.MatriculaResponseDTO;
import pe.edu.cibertec.matriculaservice.repository.MatriculaRepository;

@RequiredArgsConstructor
@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;

    public MatriculaResponseDTO obtenerMatricula(Long idMatricula) {
        MatriculaResponseDTO matricula = matriculaRepository.buscarPorId(idMatricula)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No existe la matrícula con id " + idMatricula));
        calcularTotales(matricula);
        return matricula;
    }

    private void calcularTotales(MatriculaResponseDTO matricula) {
        int totalCreditos = matricula.getListaCursosMatriculados().stream()
                .mapToInt(DetalleCursoMatriculadoDTO::getCreditos)
                .sum();
        double montoPension = matricula.getListaCursosMatriculados().stream()
                .mapToDouble(DetalleCursoMatriculadoDTO::getSubtotalCurso)
                .sum();
        matricula.setTotalCreditosInscritos(totalCreditos);
        matricula.setMontoTotalPension(montoPension);
    }
}
