package com.cibernos.transactionshandler.validation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Description validation test
 */
class DescriptionValidatorTest {

	private final DescriptionValidator descriptionValidator = new DescriptionValidator();

	@Test
	void lessThan150CharactersDescriptionTest() {

		assertTrue(
				descriptionValidator.isValid("1234.- Any description with less than 150 characters is valid.", null));
	}

	@Test
	void just150CharactersDescriptionTest() {

		// 150 characters description
		assertTrue(descriptionValidator
				.isValid(IntStream.range(0, 150).mapToObj(i -> "a").collect(Collectors.joining()), null));

		// 151 characters description
		assertFalse(descriptionValidator
				.isValid(IntStream.range(0, 151).mapToObj(i -> "a").collect(Collectors.joining()), null));
	}

	@Test
	void moreThan150CharactersDescriptionTest() {

		// 151 characters description
		assertFalse(descriptionValidator
				.isValid(IntStream.range(0, 151).mapToObj(i -> "a").collect(Collectors.joining()), null));
	}

	@Test
	void nullDescriptionTest() {

		assertTrue(descriptionValidator.isValid(null, null));
	}

}
