package io.github.uetoyo.patterns.specification;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.github.uetoyo.patterns.specification.DisjunctionSpecification;

public class DisjunctionSpecificationTest extends SpecificationTestBase {

	/* 
	 * True OR True = True
	 */
	@Test
	public void testThatTrueOrTrueSpecificationReturnsTrue() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<>(ts, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * True OR False = True
	 */
	@Test
	public void testThatTrueOrFalseSpecificationReturnsTrue() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<>(ts, fs);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False OR True = True
	 */
	@Test
	public void testThatFalseOrTrueSpecificationReturnsTrue() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<>(fs, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False AND False = False
	 */
	@Test
	public void testThatFalseOrFalseSpecificationReturnsFalse() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<>(fs, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
}
