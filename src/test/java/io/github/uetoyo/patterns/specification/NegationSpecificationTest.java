package io.github.uetoyo.patterns.specification;

import static org.junit.Assert.*;

import org.junit.Test;

public class NegationSpecificationTest extends SpecificationTestBase {

	@Test
	public void test_that_negation_returns_false() {
		NegationSpecification<Object> spec = new NegationSpecification<Object>(ts);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	@Test
	public void test_that_negation_returns_true() {
		NegationSpecification<Object> spec = new NegationSpecification<Object>(fs);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
}
