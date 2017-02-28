package io.github.uetoyo.patterns.specification;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class UnaryCompositeSpecification<T> extends CompositeSpecification<T> {
	
	/**
	 * The unary composite specification.
	 * 
	 * @param specification The inner specification.
	 */
	protected UnaryCompositeSpecification(final Specification<T> specification) {
		super(new ArrayList<Specification<T>>(Arrays.asList(specification)));
	}
	
	/**
	 * Gets the inner specification.
	 * 
	 * @return The inner specification.
	 */
	public Specification<T> getSpecification() {
		return getSpecifications().get(0);
	}
}
