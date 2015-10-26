package br.uva.siaa.api.excecoes;

public class ExcecaoNegocio extends Exception {
	private static final long serialVersionUID = 1L;

	public ExcecaoNegocio() {
		super();
	}

	public ExcecaoNegocio(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoNegocio(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoNegocio(String message) {
		super(message);
	}

	public ExcecaoNegocio(Throwable cause) {
		super(cause);
	}

}
