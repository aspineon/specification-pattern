package io.github.uetoyo.patterns.specification;

import static org.junit.Assert.*;

import org.junit.Test;

public class DisjunctionSpecificationTest extends CompositeSpecificationBase {

	/* 
	 * True OR True = True
	 */
	@Test
	public void test_that_true_or_true_specification_returns_true() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<Object>(ts, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * True OR False = True
	 */
	@Test
	public void test_that_true_or_false_specification_returns_true() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<Object>(ts, fs);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False OR True = True
	 */
	@Test
	public void test_that_false_or_true_specification_returns_true() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<Object>(fs, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False AND False = False
	 */
	@Test
	public void test_that_false_or_false_specification_returns_false() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<Object>(fs, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
}
