package io.github.uetoyo.patterns.specification;

import java.util.ArrayList;

/**
 * The specification without any component.
 *
 * @param <T> The type of entity for which the specification is defined.
 */
public abstract class NullaryCompositeSpecification<T> extends CompositeSpecification<T> {
	
	/**
	 * Creates the nullary composite specification.
	 */
	protected NullaryCompositeSpecification() {
		super(new ArrayList<Specification<T>>());
	}
}
