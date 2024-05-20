

package apifestivos.apifestivos.core.interfaces.repositorios;

import apifestivos.apifestivos.core.entidades.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {
    Optional<Festivo> findByDiaAndMes(int dia, int mes);
}