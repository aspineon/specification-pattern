package io.github.uetoyo.patterns.specification;

/**
 * Specification interface.
 * 
 * @param <T> The domain entity type.
 */
public interface Specification<T> {

	/**
	 * Check if the {@code candidate} is satisfied by the specification.
	 *
	 * @param candidate an object to test.
	 * @return {@code true} if the candidate satisfies the specification otherwise {@code false}
	 */ 
	boolean isSatisfiedBy(T candidate);
	
	/**
	 * Returns the new disjunction specification.
	 * 
	 * @param other The right-hand side specification.
	 * @return The new disjunction specification.
	 */
	default Specification<T> or(final Specification<T> other) {
		return new DisjunctionSpecification<T>(this, other);
	}

	/**
	 * Returns the new conjunction specification.
	 * 
	 * @param other The right-hand side specification.
	 * @return The new conjunction specification.
	 */
	default Specification<T> and(final Specification<T> other) {
		return new ConjunctionSpecification<T>(this, other);
	}
	
	/**
	 * Returns the new negation specification.
	 * 
	 * @param other The specification.
	 * @return The new negation specification.
	 */
	default Specification<T> not() {
		return new NegationSpecification<T>(this);
	}	
}