

package apifestivos.core.interfaces.repositorios;

import apifestivos.core.entidades.Festivo;
import org.springframework.data.jpa.repository.JpaRepository;
//(import org.springframework.stereotype.Repository;)


import java.util.Optional;

public interface IFestivoRepositorio extends JpaRepository<Festivo, Long> {
    Optional<Festivo> findByDiaAndMes(int dia, int mes);
}