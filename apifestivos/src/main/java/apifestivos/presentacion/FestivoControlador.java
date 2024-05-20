

package apifestivos.presentacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import apifestivos.aplicacion.FestivoServicio;
import apifestivos.presentacion.dtos.FestivoDTO;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/api/festivos")
public class FestivoControlador {

    @Autowired
    private FestivoServicio festivoServicio;

    @GetMapping("/verificar")
    public FestivoDTO verificarFestivo(@RequestParam String fecha) {
        try {
            LocalDate date = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            FestivoDTO festivoDTO = festivoServicio.verificarFestivo(date);
            if (festivoDTO == null) {
                throw new RuntimeException("No es festivo");
            }
            return festivoDTO;
        } catch (Exception e) {
            throw new RuntimeException("Fecha inválida o fuera de rango.", e);
        }
    }
}
