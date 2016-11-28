package io.github.uetoyo.patterns.specification;

public class DisjunctionSpecificationTest extends CompositeSpecificationTest {

	/* 
	 * True OR True = True
	 */
	public void test_that_true_or_true_specification_returns_true() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<Object>(ts, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * True OR False = True
	 */
	public void test_that_true_or_false_specification_returns_true() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<Object>(ts, fs);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False OR True = True
	 */
	public void test_that_false_or_true_specification_returns_true() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<Object>(fs, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False AND False = False
	 */
	public void test_that_false_or_false_specification_returns_false() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<Object>(fs, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
}
