package uy.com.ces.labs.poc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Say {

	private static final String ERR_EMPTY_LANG = 
			"You must provide a language";
	private static final String ERR_INVALID_LANG = 
			"There is no translation for greetings in language '%s'";

	private static final Map<String, String> GREETINGS = new LinkedHashMap<>();

	static {
		GREETINGS.put("ES", "Hola %s");
		GREETINGS.put("EN", "Hello %s");
		GREETINGS.put("PT", "Olá %s");
	}

	/**
	 * @param lang Lenguaje en el que se debe realizar el saludo
	 * @param name Nombre de la persona a saludar
	 * @return Saludo a name en lenguaje lang
	 * @throws IllegalArgumentException si name es inválido
	 */
	public String hello(final String lang, final String name) {
		if (lang == null || lang.isBlank()) {
			throw new IllegalArgumentException(ERR_EMPTY_LANG);
		}

		final String language = lang.toUpperCase();

		if (!GREETINGS.containsKey(language)) {
			throw new IllegalArgumentException(
					ERR_INVALID_LANG.formatted(language));
		}

		return GREETINGS.get(language).formatted(name);
	}

}
