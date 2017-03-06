package io.github.uetoyo.patterns.specification;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The composite specification is composed from zero or more specifications.
 * 
 * @param <T> The type of entity for which the specification is defined.
 */
abstract class CompositeSpecification<T> implements Specification<T> {
	
	private final ArrayList<Specification<T>> specifications;
	
	protected CompositeSpecification(final ArrayList<Specification<T>> specifications) {
		this.specifications = checkNotNull(specifications);
	}
	
	/**
	 * Gets the inner specifications.
	 * 
	 * @return The inner specifications.
	 */
	public List<Specification<T>> getSpecifications() {
		return specifications;
	}
	
	/**
	 * Gets the inner unsatisfied specifications.
	 * 
	 * @return The inner unsatisfied specifications.
	 */
	public Set<Specification<T>> getUnsatisfiedSpecificationsFor(final T candidate) {
		
		Set<Specification<T>> unsatisfied = new HashSet<>();
		for (Specification<T> specification : getSpecifications()) {
			if (!specification.isSatisfiedBy(candidate)) {
				unsatisfied.add(specification);
			}
		}
		return Collections.unmodifiableSet(unsatisfied);
	}
	
}
