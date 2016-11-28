package io.github.uetoyo.patterns.specification;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for the `AND` specification.
 */
public class ConjunctionSpecificationTest extends CompositeSpecificationBase {

	/* 
	 * True AND True = True
	 */
	@Test
	public void test_that_true_and_true_specification_returns_true() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<Object>(ts, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * True AND False = False
	 */
	@Test
	public void test_that_true_and_false_specification_returns_false() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<Object>(ts, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False AND True = False
	 */
	@Test
	public void test_that_false_and_true_specification_returns_false() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<Object>(fs, ts);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False AND False = False
	 */
	@Test
	public void test_that_false_and_false_specification_returns_false() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<Object>(fs, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
}
