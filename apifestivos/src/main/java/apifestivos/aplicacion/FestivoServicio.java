

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
        // ...
        return null; // Implementar lógica según sea necesario
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

