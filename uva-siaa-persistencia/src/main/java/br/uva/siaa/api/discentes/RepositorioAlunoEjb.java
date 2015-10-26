package br.uva.siaa.api.discentes;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.uva.siaa.api.entidades.validacoes.orm.Alteracao;
import br.uva.siaa.api.entidades.validacoes.orm.ConsultaPorIdentidade;
import br.uva.siaa.api.entidades.validacoes.orm.ConsultaPorIdentificacao;
import br.uva.siaa.api.entidades.validacoes.orm.Criacao;
import br.uva.siaa.api.entidades.validacoes.orm.ExclusaoPorIdentidade;
import br.uva.siaa.api.entidades.validacoes.orm.ExclusaoPorIdentificacao;
import br.uva.siaa.api.excecoes.ExcecaoNegocio;

@Stateless(name = "RepositorioAluno")
@Local(RepositorioAluno.class)
public class RepositorioAlunoEjb implements RepositorioAluno {

	@EJB
	private ValidadorAluno validador;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean isPersistido(Aluno aluno) throws ExcecaoNegocio {
		validador.garantirValido(aluno);
		
		boolean resultado;
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Boolean> query = builder.createQuery(Boolean.class);
		Root<Aluno> root = query.from(Aluno.class);
		
		if (aluno.isIdentificado()) {
			validador.garantirValido(aluno, ConsultaPorIdentificacao.class);
			// TODO Implementação
			
		} else {
			validador.garantirValido(aluno, ConsultaPorIdentidade.class);
			// TODO Implementação
		}
		
		throw new UnsupportedOperationException();
	}

	@Override
	public Aluno persistir(Aluno aluno) throws ExcecaoNegocio {
		validador.garantirValido(aluno);
		
		if (aluno.isIdentificado()) {
			validador.garantirValido(aluno, Alteracao.class);
			// TODO Implementação
			
		} else {
			validador.garantirValido(aluno, Criacao.class);
			// TODO Implementação
		}
		
		return aluno;
	}

	@Override
	public void excluir(Aluno aluno) throws ExcecaoNegocio {
		validador.garantirValido(aluno);
		
		if (aluno.isIdentificado()) {
			validador.garantirValido(aluno, ExclusaoPorIdentificacao.class);
			// TODO Implementação
			
		} else {
			validador.garantirValido(aluno, ExclusaoPorIdentidade.class);
			// TODO Implementação
		}
	}

	@Override
	public Aluno buscar(Aluno aluno) throws ExcecaoNegocio {
		validador.garantirValido(aluno);
		
		if (aluno.isIdentificado()) {
			validador.garantirValido(aluno, ExclusaoPorIdentificacao.class);
			// TODO Implementação
			
		} else {
			validador.garantirValido(aluno, ExclusaoPorIdentidade.class);
			// TODO Implementação
		}
		
		return aluno;
	}

	@Override
	public List<Aluno> listar() throws ExcecaoNegocio {
		List<Aluno> alunos = null; // TODO Implementação
		return alunos;
	}
	
}
