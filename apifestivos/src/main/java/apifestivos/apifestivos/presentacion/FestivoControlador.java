

package apifestivos.apifestivos.presentacion;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import apifestivos.apifestivos.aplicacion.FestivoServicio;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


@RestController
@RequestMapping("/api/festivos")
public class FestivoControlador {

    @Autowired
    private FestivoServicio festivoServicio;

    @GetMapping("/verificar")
    public String verificarFestivo(@RequestParam String fecha) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(fecha, formatter);
            return festivoServicio.verificarFestivo(date);
        } catch (DateTimeParseException e) {
            return "Fecha inválida";
        } catch (Exception e) {
            return "Fecha inválida";
        }
    }
}
