package br.com.api.cadastro.enuns;

import java.util.HashMap;
import java.util.Map;

public enum NivelEnum {

	INICIANTE("INICIANTE", "INICIANTE"), 
	INTERMEDIARIO("INTERMEDIARIO", "INTERMEDIARIO"), 
	AVANCADO("AVANCADO", "AVANCADO");

	private String codigo;
	private String label;

	private static final Map<String, NivelEnum> LOOKUP = new HashMap<String, NivelEnum>();
	static {
		for (NivelEnum item : NivelEnum.values()) {
			LOOKUP.put(item.codigo, item);
		}
	}

	private NivelEnum(final String codigo, final String label) {
		this.codigo = codigo;
		this.label = label;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getLabel() {
		return label;
	}

	public static NivelEnum getByCodigo(final String codigo) {
		return LOOKUP.get(codigo);
	}
}