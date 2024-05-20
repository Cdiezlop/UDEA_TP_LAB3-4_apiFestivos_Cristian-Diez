

package apifestivos.apifestivos.aplicacion;

import apifestivos.apifestivos.core.entidades.Festivo;
import apifestivos.apifestivos.core.interfaces.repositorios.IFestivoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class FestivoServicio {

    @Autowired
    private IFestivoRepositorio festivoRepositorio;

    public String verificarFestivo(LocalDate fecha) {
        int dia = fecha.getDayOfMonth();
        int mes = fecha.getMonthValue();

        Optional<Festivo> festivo = festivoRepositorio.findByDiaAndMes(dia, mes);
        if (festivo.isPresent()) {
            return "Es festivo";
        }

        Festivo festivoPascua = obtenerFestivoBasadoEnPascua(fecha.getYear(), fecha);
        if (festivoPascua != null) {
            return "Es festivo";
        }

        return "No es festivo";
    }

    private Festivo obtenerFestivoBasadoEnPascua(int year, LocalDate fecha) {
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        int dias = d + e + 10;

        LocalDate pascua = LocalDate.of(year, 3, 15).plusDays(dias);

        // Comparar fechas con los festivos basados en Pascua
        if (fecha.equals(pascua.minusDays(3)) || fecha.equals(pascua.minusDays(2)) || fecha.equals(pascua) ||
            fecha.equals(pascua.plusDays(40)) || fecha.equals(pascua.plusDays(61)) || fecha.equals(pascua.plusDays(68))) {
            return new Festivo(); // Festivo encontrado
        }

        return null; // No es un festivo basado en Pascua
    }
}

