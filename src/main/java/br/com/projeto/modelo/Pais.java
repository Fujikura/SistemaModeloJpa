
package br.com.projeto.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="pais")
public class Pais implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_pais", sequenceName = "seq_pais", allocationSize = 1)
    @GeneratedValue(generator = "seq_pais", strategy = GenerationType.SEQUENCE)
    private Long codigo;
    
    @Column(name = "nome", nullable = false, length = 50)
    @Length(max = 50, message = "O nome do país não pode ter mais de {max} caracteres")
    @NotBlank(message = "O nome do país deve ser informado")
    @NotNull(message = "O nome do país não pode ser nulo")
    private String nome;
    
    @Column(name = "iso", nullable = false, length = 5)
    @Length(max = 5, message = "O iso do país não pode ter mais de {max} caracteres")
    @NotBlank(message = "O iso do país deve ser informado")
    @NotNull(message = "O iso do país não pode ser nulo")

    private String iso;

    public Pais() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pais other = (Pais) obj;
        return Objects.equals(this.codigo, other.codigo);
    }

    @Override
    public String toString() {
        return "Pais{" + "codigo=" + codigo + ", nome=" + nome + ", iso=" + iso + '}';
    }
    
    
}
