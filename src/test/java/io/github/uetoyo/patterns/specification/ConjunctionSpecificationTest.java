package io.github.uetoyo.patterns.specification;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for the `AND` specification.
 */
public class ConjunctionSpecificationTest extends SpecificationTestBase {

	/* 
	 * True AND True = True
	 */
	@Test
	public void testThatTrueAndTrueSpecificationReturnsTrue() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<>(ts, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * True AND False = False
	 */
	@Test
	public void testThatTrueAndFalseSpecificationReturnsFalse() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<>(ts, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False AND True = False
	 */
	@Test
	public void testThatFalseAndTrueSpecificationReturnsFalse() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<>(fs, ts);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False AND False = False
	 */
	@Test
	public void testThatFalseAndFalseSpecificationReturnsFalse() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<>(fs, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
}
