package gia.utp.primerproyecto.primerproyecto.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "editorial")
public class EditorialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "nombre_editorial")
    private String nombreEditorial;

    private String direccion;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true)
    private List<LibroEntity> libros;

    public EditorialEntity(Integer id, String nombreEditorial, String direccion) {
        this.id = id;
        this.nombreEditorial = nombreEditorial;
        this.direccion = direccion;
    }
}
