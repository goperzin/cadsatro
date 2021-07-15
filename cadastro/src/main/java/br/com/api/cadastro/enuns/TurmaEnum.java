package br.com.api.cadastro.enuns;

import java.util.HashMap;
import java.util.Map;

public enum TurmaEnum {

	SAMBA_TRADICIONAL("SAMBA_TRADICIONAL", "Samba de Gafieira"), 
	ZOUK("ZOUK", "Zouk dos lunaticos"), 
	SAMBA_FUNKEADO("SAMBA_FUNKEADO", "E tudo meu...");

	private String codigo;
	private String label;

	private static final Map<String, TurmaEnum> LOOKUP = new HashMap<String, TurmaEnum>();
	static {
		for (TurmaEnum item : TurmaEnum.values()) {
			LOOKUP.put(item.codigo, item);
		}
	}

	private TurmaEnum(final String codigo, final String label) {
		this.codigo = codigo;
		this.label = label;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getLabel() {
		return label;
	}

	public static TurmaEnum getByCodigo(final String codigo) {
		return LOOKUP.get(codigo);
	}
}