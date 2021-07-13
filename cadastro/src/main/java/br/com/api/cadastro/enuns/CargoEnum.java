package br.com.api.cadastro.enuns;

import java.util.HashMap;
import java.util.Map;

public enum CargoEnum {

	PROFESSOR("PROFESSOR", "PROFESSOR"), 
	ATENDENTE("ATENDENTE", "ATENDENTE"), 
	BOLSISTA("BOLSISTA", "BOLSISTA");

	private String codigo;
	private String label;

	private static final Map<String, CargoEnum> LOOKUP = new HashMap<String, CargoEnum>();
	static {
		for (CargoEnum item : CargoEnum.values()) {
			LOOKUP.put(item.codigo, item);
		}
	}

	private CargoEnum(final String codigo, final String label) {
		this.codigo = codigo;
		this.label = label;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getLabel() {
		return label;
	}

	public static CargoEnum getByCodigo(final String codigo) {
		return LOOKUP.get(codigo);
	}
}