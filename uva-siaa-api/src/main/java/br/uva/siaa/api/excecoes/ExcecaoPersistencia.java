package br.uva.siaa.api.excecoes;

public class ExcecaoPersistencia extends ExcecaoNegocio {
	private static final long serialVersionUID = 1L;

	public ExcecaoPersistencia() {
		super();
	}

	public ExcecaoPersistencia(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExcecaoPersistencia(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcecaoPersistencia(String message) {
		super(message);
	}

	public ExcecaoPersistencia(Throwable cause) {
		super(cause);
	}

}
