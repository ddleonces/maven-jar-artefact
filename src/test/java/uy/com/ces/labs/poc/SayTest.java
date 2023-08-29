package uy.com.ces.labs.poc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SayTest {

	Say say;

	@BeforeEach
	void beforeEach() {
		say = new Say();
	}

	@ParameterizedTest
	@DisplayName("Check translations")
	@CsvSource({ "ES,Juan,Hola Juan", "EN,Mary,Hello Mary", "PT,Ramona,Olá Ramona" })
	void esTest(String lang, String name, String expect) {
		assertEquals(expect, say.hello(lang, name));
	}

	@Test
	@DisplayName("Check null language")
	void nullLanguage() {
		try {
			say.hello(null, "Elsa");
		} catch (IllegalArgumentException e) {
			assertEquals("You must provide a language", e.getMessage());
		}
	}

	@Test
	@DisplayName("Check empty language")
	void emptyLanguage() {
		try {
			say.hello("", "Santíago");
		} catch (IllegalArgumentException e) {
			assertEquals("You must provide a language", e.getMessage());
		}
	}

	@Test
	@DisplayName("Check invalid language")
	void invalidLanguage() {
		try {
			say.hello("DE", "Friedrich");
		} catch (IllegalArgumentException e) {
			assertEquals("There is no translation for greetings in language 'DE'", e.getMessage());
		}
	}

}
