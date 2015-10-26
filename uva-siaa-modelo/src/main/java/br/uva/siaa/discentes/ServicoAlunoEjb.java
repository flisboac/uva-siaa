package br.uva.siaa.discentes;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import br.uva.siaa.api.discentes.RepositorioAluno;
import br.uva.siaa.api.discentes.ServicoAluno;

@Stateless(name = "AlunoService")
@Local(ServicoAluno.class)
public class ServicoAlunoEjb implements ServicoAluno {
	
	@EJB
	private RepositorioAluno repositorio;
		
}
