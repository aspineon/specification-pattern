package io.github.uetoyo.patterns.specification;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

import io.github.uetoyo.patterns.specification.CompositeSpecification;
import io.github.uetoyo.patterns.specification.ConjunctionSpecification;
import io.github.uetoyo.patterns.specification.Specification;

public class UnsatisfiedTest extends SpecificationTestBase {
	
	@Test
	public void shouldReturnUnsatisfiedSpecification() {
		CompositeSpecification<Object> spec = new ConjunctionSpecification<Object>(ts, fs);
		Set<Specification<Object>> unsatisfiedSpecs  = spec.getUnsatisfiedSpecificationsFor(new Object());
		assertTrue(unsatisfiedSpecs.size() == 1);
	}
	
	@Test
	public void shouldReturnOnlyOneUnsatisfiedSpecificationIfTheAreOfSameType() {
		CompositeSpecification<Object> spec = new ConjunctionSpecification<Object>(fs, fs);
		Set<Specification<Object>> unsatisfiedSpecs  = spec.getUnsatisfiedSpecificationsFor(new Object());
		assertTrue(unsatisfiedSpecs.size() == 1);
	}
}
