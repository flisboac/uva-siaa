package br.uva.siaa.api.excecoes;

import br.uva.siaa.api.entidades.validacoes.Violacao;

public class ExcecaoValidacao extends ExcecaoNegocio {
	private static final long serialVersionUID = 1L;

	private final Violacao violacao;
	
	public ExcecaoValidacao() {
		super();
		this.violacao = null;
	}

	public ExcecaoValidacao(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.violacao = null;
	}

	public ExcecaoValidacao(String message, Throwable cause) {
		super(message, cause);
		this.violacao = null;
	}

	public ExcecaoValidacao(String message) {
		super(message);
		this.violacao = null;
	}

	public ExcecaoValidacao(Throwable cause) {
		super(cause);
		this.violacao = null;
	}

	public ExcecaoValidacao(Violacao violacao) {
		super(violacao.isViolado() ? violacao.getResumoViolacao() : "Ocorreu um erro de violação.");
		this.violacao = null;
	}
	
	public ExcecaoValidacao(Violacao violacao, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(violacao.isViolado() ? violacao.getResumoViolacao() : "Ocorreu um erro de violação.",
				cause, enableSuppression, writableStackTrace);
		this.violacao = violacao;
	}
	
	public ExcecaoValidacao(Violacao violacao, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.violacao = violacao;
	}

	public ExcecaoValidacao(Violacao violacao, String message, Throwable cause) {
		super(message, cause);
		this.violacao = violacao;
	}

	public ExcecaoValidacao(Violacao violacao, String message) {
		super(message);
		this.violacao = violacao;
	}

	public ExcecaoValidacao(Violacao violacao, Throwable cause) {
		super(violacao.isViolado() ? violacao.getResumoViolacao() : "Ocorreu um erro de violação.");
		this.violacao = violacao;
	}

	public Violacao getViolacao() {
		return violacao;
	}
	
}
