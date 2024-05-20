

package apifestivos.aplicacion;

import apifestivos.core.entidades.Festivo;
import apifestivos.core.interfaces.repositorios.IFestivoRepositorio;
//(import apifestivos.apifestivos.core.interfaces.servicios.IFestivoServicio;)
import apifestivos.presentacion.dtos.FestivoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class FestivoServicio {

    @Autowired
    private IFestivoRepositorio festivoRepositorio;

    public FestivoDTO verificarFestivo(LocalDate fecha) {
        int dia = fecha.getDayOfMonth();
        int mes = fecha.getMonthValue();
        
        Optional<Festivo> festivo = festivoRepositorio.findByDiaAndMes(dia, mes);
        if (festivo.isPresent()) {
            return convertirAFestivoDTO(festivo.get());
        }
        
        Festivo festivoPascua = obtenerFestivoBasadoEnPascua(fecha.getYear());
        if (festivoPascua != null) {
            return convertirAFestivoDTO(festivoPascua);
        }
        
        return null;
    }

    private Festivo obtenerFestivoBasadoEnPascua(int year) {
        // Lógica para calcular la fecha de Pascua y encontrar festivos relativos a ella
        // Implementación de la lógica de cálculo de Pascua
        int a = year % 19;
        int b = year % 4;
        int c = year % 7;
        int d = (19 * a + 24) % 30;
        int e = (2 * b + 4 * c + 6 * d + 5) % 7;
        int dias = d + e + 10;

        LocalDate pascua = LocalDate.of(year, 3, 15).plusDays(dias);

        // Buscar los festivos basados en Pascua
        Optional<Festivo> festivo = festivoRepositorio.findByDiaAndMes(pascua.getDayOfMonth(), pascua.getMonthValue());
        return festivo.orElse(null);
    }

    private FestivoDTO convertirAFestivoDTO(Festivo festivo) {
        FestivoDTO dto = new FestivoDTO();
        dto.setId(festivo.getId());
        dto.setNombre(festivo.getNombre());
        dto.setDia(festivo.getDia());
        dto.setMes(festivo.getMes());
        dto.setDiasPascua(festivo.getDiasPascua());
        dto.setTipo(festivo.getTipo().getTipo());
        return dto;
    }
}

