package io.github.uetoyo.patterns.specification;

import java.util.ArrayList;
import java.util.Arrays;

import io.github.uetoyo.patterns.specification.protocols.Immutable;

/**
 * The binary composite specification.
 * 
 * @param <T> The type of entity for which the specification is defined.
 */
@Immutable
public abstract class BinaryCompositeSpecification<T> extends CompositeSpecification<T> {
	
	/**
	 * Creates the binary composite specification.
	 *
	 * @param specificationOne The left-hand side specification.
	 * @param specificationTwo The right-hand side specification.
	 */
	protected BinaryCompositeSpecification(final Specification<T> specificationOne, final Specification<T> specificationTwo) {
		super(new ArrayList<Specification<T>>(Arrays.asList(specificationOne, specificationTwo)));
	}
	
	/**
	 * Returns the left-hand side specification.
	 * 
	 * @return The left-hand side specification.
	 */
	public Specification<T> getSpecificationOne() {
		return getSpecifications().get(0);
	}
	
	/**
	 * Returns the right-hand side specification.
	 * 
	 * @return The right-hand side specification.
	 */
	public Specification<T> getSpecificationTwo() {
		return getSpecifications().get(1);
	}
}
