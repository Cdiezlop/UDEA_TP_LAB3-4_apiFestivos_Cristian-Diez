

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

        // Verificar festivos fijos
        Optional<Festivo> festivo = festivoRepositorio.findByDiaAndMes(dia, mes);
        if (festivo.isPresent()) {
            return "Es festivo";
        }

        // Verificar festivos basados en Pascua
        if (esFestivoBasadoEnPascua(fecha)) {
            return "Es festivo";
        }

        return "No es festivo";
    }

    private boolean esFestivoBasadoEnPascua(LocalDate fecha) {
        int year = fecha.getYear();
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        int dias = d + e + 10;

        LocalDate pascua = LocalDate.of(year, 3, 15).plusDays(dias);

        // Comparar fechas con los festivos basados en Pascua
        List<LocalDate> fechasPascua = List.of(
                pascua.minusDays(3), // Jueves Santo
                pascua.minusDays(2), // Viernes Santo
                pascua,              // Domingo de Pascua
                pascua.plusDays(40), // Ascensión del Señor
                pascua.plusDays(61), // Corpus Christi
                pascua.plusDays(68)  // Sagrado Corazón de Jesús
        );

        return fechasPascua.contains(fecha);
    }
}

