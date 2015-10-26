package br.uva.siaa.api.discentes;

import br.uva.siaa.api.entidades.validacoes.Violacao;
import br.uva.siaa.api.excecoes.ExcecaoNegocio;

public interface ValidadorAluno {

	public void garantirValido(Aluno aluno, Class<?>... validacoes) throws ExcecaoNegocio;

	public void garantirValido(Aluno aluno, Object propriedade, Class<?>... validacoes) throws ExcecaoNegocio;
	
	public Violacao validar(Aluno aluno, Class<?>... validacoes) throws ExcecaoNegocio;

	public Violacao validar(Aluno aluno, Object propriedade, Class<?>... validacoes) throws ExcecaoNegocio;
	
}
