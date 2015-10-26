package br.uva.siaa.api.discentes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity(name = "aluno")
@Table(name = "aluno", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "matricula" }) // Identidade
}, indexes = {
		@Index(columnList = "matricula")
})
@SequenceGenerator(name = "sq_aluno", sequenceName = "sq_aluno", allocationSize = 1)
public class AlunoJpa extends Aluno {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "sq_aluno", strategy = GenerationType.SEQUENCE)
	@Override
	public Long getId() {
		return super.getId();
	} 
	
	@Column(length = 15, nullable = false)
	@Override
	public String getMatricula() {
		return super.getMatricula();
	}

	@Column(length = 50)
	@Override
	public String getNome() {
		return super.getNome();
	}

	@Override
	public Double getNotaTeste() {
		return super.getNotaTeste();
	}

	@Override
	public Double getNotaProva() {
		return super.getNotaProva();
	}

	@Override
	public Integer getQuantidadeFaltas() {
		return super.getQuantidadeFaltas();
	}

}
