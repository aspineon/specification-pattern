package io.github.uetoyo.patterns.specification;

import junit.framework.TestCase;

/**
 * Unit test for specification.
 */
public class SpecificationTest extends TestCase {

	private final AlwaysTrueSpecification ts = new AlwaysTrueSpecification();
	private final AlwaysFalseSpecification fs = new AlwaysFalseSpecification();
	
	public void test_true_and_true_specification_should_return_true() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<Object>(ts, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	public void test_true_and_false_specification_should_return_false() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<Object>(ts, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	public void test_false_and_false_specification_should_return_false() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<Object>(fs, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
}
