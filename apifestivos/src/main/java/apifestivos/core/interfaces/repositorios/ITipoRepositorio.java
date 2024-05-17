package apifestivos.core.interfaces.repositorios;

import apifestivos.core.entidades.Tipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ITipoRepositorio extends JpaRepository<Tipo, Long> {
}

