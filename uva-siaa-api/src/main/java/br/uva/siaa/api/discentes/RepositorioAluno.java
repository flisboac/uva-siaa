package br.uva.siaa.api.discentes;

import java.util.List;

import br.uva.siaa.api.excecoes.ExcecaoNegocio;

public interface RepositorioAluno {

	public boolean isPersistido(Aluno aluno) throws ExcecaoNegocio;
	
	public Aluno persistir(Aluno aluno) throws ExcecaoNegocio;
	
	public void excluir(Aluno aluno) throws ExcecaoNegocio;
	
	public Aluno buscar(Aluno aluno) throws ExcecaoNegocio;
	
	public List<Aluno> listar() throws ExcecaoNegocio;
	
}
