package io.github.uetoyo.patterns.specification;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * The composite specification is composed form zero or more specifications.
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
}
