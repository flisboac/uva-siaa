package br.uva.siaa.discentes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.uva.siaa.api.entidades.validacoes.Violacao;

public class ViolacaoAluno implements Violacao {

	private boolean violado;
	
	private String resumoViolacao;
	
	private Map<Object, List<String>> mensagensPorPropriedade = new HashMap<>();

	public ViolacaoAluno() {
		this.mensagensPorPropriedade.put(null, new ArrayList<String>());
	}
	
	@Override
	public boolean isViolado() {
		return violado;
	}

	public void setViolado(boolean violado) {
		this.violado = violado;
	}

	@Override
	public String getResumoViolacao() {
		return resumoViolacao;
	}

	public void setResumoViolacao(String resumoViolacao) {
		this.resumoViolacao = resumoViolacao;
	}

	@Override
	public List<String> getMensagensGlobais() {
		return mensagensPorPropriedade.get(null);
	}

	public void setMensagensGlobais(List<String> mensagensGlobais) {
		this.mensagensPorPropriedade.put(null, mensagensGlobais);
	}

	@Override
	public Map<Object, List<String>> getMensagensPorPropriedade() {
		return mensagensPorPropriedade;
	}

	public void setMensagensPorPropriedade(Map<Object, List<String>> mensagensPorPropriedade) {
		this.mensagensPorPropriedade = mensagensPorPropriedade;
	}
	
	public static ViolacaoAluno gerar(String mensagemResumo) {
		ViolacaoAluno violacao = new ViolacaoAluno();
		violacao.resumoViolacao = mensagemResumo;
		violacao.violado = true;
		return violacao;
	}
	
	public ViolacaoAluno comResumoViolacao(String mensagem) {
		this.resumoViolacao = mensagem;
		this.violado = true;
		return this;
	}
	
	public ViolacaoAluno addMensagemGlobal(String mensagem) {
		this.mensagensPorPropriedade.get(null).add(mensagem);
		return this;
	}
	
	public ViolacaoAluno addMensagemPorPropriedade(Object parametro, String mensagem) {
		List<String> listaMensagens = this.mensagensPorPropriedade.get(parametro);
		if (listaMensagens == null) {
			listaMensagens = new ArrayList<>();
			this.mensagensPorPropriedade.put(parametro, listaMensagens);
		}
		listaMensagens.add(mensagem);
		return this;
	}
}
