package pe.edu.cibertec.matriculaservice.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/api/v1/matriculas")
public class ConfiguracionController {

    @Value("${edusmart.sede}")
    private String sede;

    @Value("${edusmart.costo-credito}")
    private Double costoCredito;

    @Value("${edusmart.max-creditos-ciclo}")
    private Integer maxCreditosCiclo;

    @Value("${edusmart.mensaje-bienvenida}")
    private String mensajeBienvenida;

    @Value("${edusmart.limite-cuotas-pago}")
    private Integer limiteCuotasPago;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @GetMapping("/configuracion")
    public ResponseEntity<Map<String, Object>> obtenerConfiguracion() {
        Map<String, Object> configuracion = new LinkedHashMap<>();
        configuracion.put("sede", sede);
        configuracion.put("costo-credito", costoCredito);
        configuracion.put("max-creditos-ciclo", maxCreditosCiclo);
        configuracion.put("mensaje-bienvenida", mensajeBienvenida);
        configuracion.put("limite-cuotas-pago", limiteCuotasPago);
        configuracion.put("datasource.url", datasourceUrl);
        return ResponseEntity.ok(configuracion);
    }
}
