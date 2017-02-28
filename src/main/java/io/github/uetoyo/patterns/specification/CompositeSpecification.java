package io.github.uetoyo.patterns.specification;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * The composite specification is composed form zero or more specifications.
 */
public abstract class CompositeSpecification<T> implements Specification<T> {
	
	private final Specification<T>[] specifications;
	
	@SafeVarargs
	public CompositeSpecification(final Specification<T>... specifications) {
		this.specifications = checkNotNull(specifications);
	}
	
	protected Specification<T>[] getSpecifications() {
		return specifications;
	}
}
