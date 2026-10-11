package pe.edu.cibertec.matriculaservice.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import pe.edu.cibertec.matriculaservice.dto.DetalleCursoMatriculadoDTO;
import pe.edu.cibertec.matriculaservice.dto.MatriculaResponseDTO;

@Repository
public class MatriculaRepository {

    private final Map<Long, MatriculaResponseDTO> matriculas = new LinkedHashMap<>();

    public MatriculaRepository() {
        guardar(MatriculaResponseDTO.builder()
                .idMatricula(1L).codigoMatricula("MAT-2026-0001")
                .fechaMatricula(LocalDateTime.of(2026, 3, 2, 9, 30))
                .estudianteId(1L).periodoAcademico("2026-I").estadoMatricula("EN_PROCESO")
                .listaCursosMatriculados(new ArrayList<>(List.of(
                        detalle(1L, "INF101", "Programación I", "A", 4, 150.0),
                        detalle(2L, "INF201", "Estructuras de Datos", "B", 4, 150.0),
                        detalle(4L, "MAT101", "Matemática I", "A", 3, 140.0))))
                .build());

        guardar(MatriculaResponseDTO.builder()
                .idMatricula(2L).codigoMatricula("MAT-2026-0002")
                .fechaMatricula(LocalDateTime.of(2026, 3, 3, 11, 15))
                .estudianteId(2L).periodoAcademico("2026-I").estadoMatricula("EN_PROCESO")
                .listaCursosMatriculados(new ArrayList<>(List.of(
                        detalle(1L, "INF101", "Programación I", "A", 4, 150.0),
                        detalle(3L, "INF301", "Base de Datos", "A", 4, 160.0))))
                .build());

        guardar(MatriculaResponseDTO.builder()
                .idMatricula(3L).codigoMatricula("MAT-2025-0107")
                .fechaMatricula(LocalDateTime.of(2025, 8, 18, 10, 0))
                .estudianteId(1L).periodoAcademico("2025-II").estadoMatricula("CONFIRMADA")
                .listaCursosMatriculados(new ArrayList<>(List.of(
                        detalle(6L, "ING101", "Inglés Técnico", "A", 2, 120.0))))
                .build());
    }

    private DetalleCursoMatriculadoDTO detalle(Long idCurso, String codigo, String nombre,
                                               String seccion, int creditos, double costoPorCredito) {
        return DetalleCursoMatriculadoDTO.builder()
                .idCurso(idCurso).codigoCurso(codigo).nombreCurso(nombre).seccion(seccion)
                .creditos(creditos).costoPorCredito(costoPorCredito)
                .subtotalCurso(creditos * costoPorCredito)
                .build();
    }

    public Optional<MatriculaResponseDTO> buscarPorId(Long idMatricula) {
        return Optional.ofNullable(matriculas.get(idMatricula));
    }

    public List<MatriculaResponseDTO> listarPorEstudiante(Long estudianteId) {
        return matriculas.values().stream()
                .filter(m -> estudianteId.equals(m.getEstudianteId()))
                .toList();
    }

    public MatriculaResponseDTO guardar(MatriculaResponseDTO matricula) {
        matriculas.put(matricula.getIdMatricula(), matricula);
        return matricula;
    }
}