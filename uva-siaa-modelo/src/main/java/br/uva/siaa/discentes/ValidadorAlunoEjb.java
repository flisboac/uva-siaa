package br.uva.siaa.discentes;

import java.util.Set;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import br.uva.siaa.api.discentes.Aluno;
import br.uva.siaa.api.discentes.ValidadorAluno;
import br.uva.siaa.api.entidades.validacoes.Violacao;
import br.uva.siaa.api.excecoes.ExcecaoNegocio;
import br.uva.siaa.api.excecoes.ExcecaoValidacao;

// TODO Unificar verificação dos métodos de validação
// TODO Capturar ValidationException e fazer wrap para ErroValidacao
@Stateless(name = "ValidadorAluno")
@Local(ValidadorAluno.class)
public class ValidadorAlunoEjb implements ValidadorAluno {

	@Resource
	private Validator validator;

	@Override
	public Violacao validar(Aluno aluno, Class<?>... validacoes) throws ExcecaoNegocio {
		ViolacaoAluno violacao = new ViolacaoAluno();
		
		if (aluno == null) {
			violacao.addMensagemGlobal("Aluno não pode ser nulo.");
			
		} else if (validacoes.length > 0) {
			Set<ConstraintViolation<Aluno>> violacoes = validator.validate(aluno, validacoes);
			
			if (!violacoes.isEmpty()) {
				if (violacoes.size() > 1) {
					violacao.addMensagemGlobal("Múltiplas violações de restrições em Aluno.");	
				}
				
				for (ConstraintViolation<Aluno> cv : violacoes) {
					if (violacoes.size() > 1) {
						violacao.addMensagemPorPropriedade(cv.getPropertyPath(), cv.getMessage());
						
					} else {
						violacao.addMensagemGlobal(cv.getPropertyPath() + ": " + cv.getMessage());
						break;
					}
				}
			}
		}
		
		return violacao;
	}

	@Override
	public void garantirValido(Aluno aluno, Class<?>... validacoes) throws ExcecaoNegocio {
		Violacao violacao = validar(aluno, validacoes);
		
		if (violacao.isViolado()) {
			throw new ExcecaoValidacao(violacao);
		}
	}

	@Override
	public void garantirValido(Aluno aluno, Object propriedade, Class<?>... validacoes) throws ExcecaoNegocio {
		Violacao violacao = validar(aluno, validacoes);
		
		if (violacao.isViolado()) {
			throw new ExcecaoValidacao(violacao);
		}
	}

	@Override
	public Violacao validar(Aluno aluno, Object propriedade, Class<?>... validacoes) throws ExcecaoNegocio {
		ViolacaoAluno violacao = new ViolacaoAluno();
		
		if (aluno == null) {
			violacao.addMensagemGlobal("Aluno não pode ser nulo.");
			
		} else if (validacoes.length > 0) {
			String nomePropriedade = propriedade.toString();
			Set<ConstraintViolation<Aluno>> violacoes = 
					validator.validateProperty(aluno, nomePropriedade, validacoes);
			
			if (!violacoes.isEmpty()) {
				if (violacoes.size() > 1) {
					violacao.addMensagemGlobal("Múltiplas violações de restrições em Aluno.");	
				}
				
				for (ConstraintViolation<Aluno> cv : violacoes) {
					if (violacoes.size() > 1) {
						violacao.addMensagemPorPropriedade(cv.getPropertyPath(), cv.getMessage());
						
					} else {
						violacao.addMensagemGlobal(cv.getPropertyPath() + ": " + cv.getMessage());
						break;
					}
				}
			}
		}
		
		return violacao;
	}

}
