package pe.edu.cibertec.matriculaservice.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaResponseDTO {
    private Long idMatricula;
    private String codigoMatricula;
    private LocalDateTime fechaMatricula;
    private Long estudianteId;
    private String periodoAcademico;
    private String estadoMatricula;
    private List<DetalleCursoMatriculadoDTO> listaCursosMatriculados;
    private Integer totalCreditosInscritos;
    private Double montoTotalPension;
}
