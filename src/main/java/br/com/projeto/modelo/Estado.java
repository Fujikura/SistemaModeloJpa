package br.com.projeto.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;

@Entity
@Table(name="estado")
public class Estado implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_estado", sequenceName = "seq_estado", allocationSize = 1)
    @GeneratedValue(generator = "seq_estado", strategy = GenerationType.SEQUENCE)
    private Long id;
    
    @Column(name = "nome", length = 50, nullable = false)
    @NotBlank(message = "O nome do estado deve ser informado")
    @NotNull(message = "O nome do estado não pode ser nulo")
    private String nome;
    
    @Column(name = "uf", length = 2, nullable = false)
    @NotBlank(message = "A uf deve ser informado")
    @NotNull(message = "A uf não pode ser nulo")
    private String uf;
    
    @ManyToOne
    @JoinColumn(name = "pais", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_pais")
    @NotNull(message = "O país deve ser informado")
    private Pais pais;

    public Estado() {
    }

    public Long getId() {
        return id;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Estado other = (Estado) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Estado{" + "id=" + id + ", uf=" + uf + ", nome=" + nome + ", pais=" + pais + '}';
    }
    
    
}
