package br.uva.siaa.api.entidades.validacoes;

import java.util.List;
import java.util.Map;

public interface Violacao {

	public boolean isViolado();
	
	public String getResumoViolacao();
	
	public List<String> getMensagensGlobais();
	
	public Map<Object, List<String>> getMensagensPorPropriedade();
}
