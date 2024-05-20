

package apifestivos.apifestivos.core.entidades;

import jakarta.persistence.*;


import java.util.Set;

@Entity
public class Tipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @OneToMany(mappedBy = "tipo")
    private Set<Festivo> festivos;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Festivo> getFestivos() {
        return festivos;
    }

    public void setFestivos(Set<Festivo> festivos) {
        this.festivos = festivos;
    }
}

