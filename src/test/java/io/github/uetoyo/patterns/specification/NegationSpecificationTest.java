package io.github.uetoyo.patterns.specification;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.uetoyo.patterns.specification.NegationSpecification;

public class NegationSpecificationTest extends SpecificationTestBase {

	@Test
	public void testThatNegationReturnsFalse() {
		NegationSpecification<Object> spec = new NegationSpecification<>(ts);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	@Test
	public void testThatNegationReturnsTrue() {
		NegationSpecification<Object> spec = new NegationSpecification<>(fs);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
}
