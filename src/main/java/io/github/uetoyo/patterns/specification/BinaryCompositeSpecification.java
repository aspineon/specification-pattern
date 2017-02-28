package io.github.uetoyo.patterns.specification;


/**
 * The binary composite specification.
 * 
 * @param <T> The type of entity for which the specification is used.
 */
public abstract class BinaryCompositeSpecification<T> implements Specification<T> {
	
	private final Specification<T> specOne;
	private final Specification<T> specTwo;
	
	/**
	 * Creates the binary composite specification.
	 *
	 * @param first The left-hand side specification.
	 * @param second The right-hand side specification.
	 */
	protected BinaryCompositeSpecification(final Specification<T> specOne, final Specification<T> specTwo) {
		if (specOne == null || specTwo == null) {
			throw new IllegalArgumentException("The `null` value is not allowed!");
		}
		this.specOne = specOne;
		this.specTwo = specTwo;
	}
	
	/**
	 * Returns the new disjunction specification.
	 * 
	 * @param other The right-hand side specification.
	 * @return The new disjunction specification.
	 */
	Specification<T> or(final Specification<T> other) {
		return new DisjunctionSpecification<T>(this, other);
	}

	/**
	 * Returns the new conjunction specification.
	 * 
	 * @param other The right-hand side specification.
	 * @return The new conjunction specification.
	 */
	Specification<T> and(final Specification<T> other) {
		return new ConjunctionSpecification<T>(this, other);
	}
	
	/**
	 * Returns the new negation specification.
	 * 
	 * @param other The specification.
	 * @return The new negation specification.
	 */
	Specification<T> not() {
		return new NegationSpecification<T>(this);
	}	
	
	/**
	 * {@inheritDoc}
	 */
	public abstract boolean isSatisfiedBy(final T t);
	
	/**
	 * Returns the left-hand side specification.
	 * @return The left-hand side specification.
	 */
	public Specification<T> getSpecificationOne() {
		return specOne;
	}
	
	/**
	 * Returns the right-hand side specification.
	 * @return The right-hand side specification.
	 */
	public Specification<T> getSpecificationTwo() {
		return specTwo;
	}
}
