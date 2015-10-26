package br.uva.siaa.api.excecoes;

import br.uva.siaa.api.entidades.validacoes.Violacao;

public class ErroValidacao extends ErroNegocio {
	private static final long serialVersionUID = 1L;

	private final Violacao violacao;
	
	public ErroValidacao() {
		super();
		this.violacao = null;
	}

	public ErroValidacao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.violacao = null;
	}

	public ErroValidacao(String message, Throwable cause) {
		super(message, cause);
		this.violacao = null;
	}

	public ErroValidacao(String message) {
		super(message);
		this.violacao = null;
	}

	public ErroValidacao(Throwable cause) {
		super(cause);
		this.violacao = null;
	}

	public ErroValidacao(Violacao violacao) {
		super(violacao.isViolado() ? violacao.getResumoViolacao() : "Ocorreu um erro de violação.");
		this.violacao = null;
	}
	
	public ErroValidacao(Violacao violacao, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(violacao.isViolado() ? violacao.getResumoViolacao() : "Ocorreu um erro de violação.",
				cause, enableSuppression, writableStackTrace);
		this.violacao = violacao;
	}
	
	public ErroValidacao(Violacao violacao, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.violacao = violacao;
	}

	public ErroValidacao(Violacao violacao, String message, Throwable cause) {
		super(message, cause);
		this.violacao = violacao;
	}

	public ErroValidacao(Violacao violacao, String message) {
		super(message);
		this.violacao = violacao;
	}

	public ErroValidacao(Violacao violacao, Throwable cause) {
		super(violacao.isViolado() ? violacao.getResumoViolacao() : "Ocorreu um erro de violação.");
		this.violacao = violacao;
	}

	public Violacao getViolacao() {
		return violacao;
	}
	
}
