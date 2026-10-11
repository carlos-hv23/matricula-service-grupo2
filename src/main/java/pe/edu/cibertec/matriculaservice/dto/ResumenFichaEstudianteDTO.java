package pe.edu.cibertec.matriculaservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResumenFichaEstudianteDTO {
    private Long estudianteId;
    private String nombreEstudiante;
    private String carrera;
    private String sede;
    private Integer totalMatriculasRealizadas;
    private Double promedioPonderadoAcumulado;
    private List<MatriculaResponseDTO> historialMatriculas;
    private List<CursoDisponibilidadDTO> catalogoCursosElegibles;
    private String situacionAcademica;
}
