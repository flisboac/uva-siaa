package br.uva.siaa.api.discentes;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import br.uva.siaa.api.entidades.validacoes.orm.Identidade;
import br.uva.siaa.api.entidades.validacoes.orm.Identificacao;
import br.uva.siaa.api.entidades.validacoes.orm.Integridade;

public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotNull(message = "ID de aluno não informado.", groups = {Identificacao.class})
	private Long id;
	
	@NotNull(message = "Informe uma matrícula.", groups = {Identidade.class})
	@Size(min = 1, max = 15, message = "A matrícula dete conter entre {min} e {max} caracteres.", groups = {Identidade.class})
	@Pattern(regexp = "[0-9]+", message = "A matrícula do aluno deve conter apenas números.", groups = {Identidade.class})
	private String matricula;
	
	@NotNull(message = "Informe um nome para o aluno.", groups = {Integridade.class})
	@Size(min = 1, max = 50, message = "O nome do aluno deve estar entre {min} e {max} caracteres.", groups = {Integridade.class})
	private String nome;
	
	@Max(value = 10, message = "A nota do teste deve ser no máximo {value}.", groups = {Integridade.class})
	@Min(value = 0, message = "A nota do teste deve ser no mínimo {value}.", groups = {Integridade.class})
	private Double notaTeste;

	@Max(value = 10, message = "A nota da prova deve ser no máximo {value}.", groups = {Integridade.class})
	@Min(value = 0, message = "A nota da prova deve ser no mínimo {value}.", groups = {Integridade.class})
	private Double notaProva;
	
	@Min(value = 0, message = "O número de faltas não pode ser negativo.", groups = {Integridade.class})
	private Integer quantidadeFaltas;
	
	public Aluno() {
	}
	
	public Aluno(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public boolean isIdentificado() {
		return id != null;
	} 
	
	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getNotaTeste() {
		return notaTeste;
	}

	public void setNotaTeste(Double notaTeste) {
		this.notaTeste = notaTeste;
	}

	public Double getNotaProva() {
		return notaProva;
	}

	public void setNotaProva(Double notaProva) {
		this.notaProva = notaProva;
	}

	public Integer getQuantidadeFaltas() {
		return quantidadeFaltas;
	}

	public void setQuantidadeFaltas(Integer quantidadeFaltas) {
		this.quantidadeFaltas = quantidadeFaltas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + "]";
	}
	
}
