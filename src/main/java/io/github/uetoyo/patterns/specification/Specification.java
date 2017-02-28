package io.github.uetoyo.patterns.specification;

import java.util.function.Predicate;

/**
 * The composite specification fluid interface.
 * 
 * @param <T> The type of entity for which the specification is defined.
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
	 * Returns the new disjunction specification composed from this and other specifications.
	 * 
	 * @param other The right-hand side specification.
	 * @return The new disjunction specification.
	 */
	default Specification<T> or(final Specification<T> other) {
		return new DisjunctionSpecification<T>(this, other);
	}

	/**
	 * Returns the new conjunction specification composed from this and other specifications.
	 * 
	 * @param other The right-hand side specification.
	 * @return The new conjunction specification.
	 */
	default Specification<T> and(final Specification<T> other) {
		return new ConjunctionSpecification<T>(this, other);
	}
	
	/**
	 * Returns the new negation specification composed from this specification.
	 * 
	 * @param other The specification.
	 * @return The new negation specification.
	 */
	default Specification<T> not() {
		return new NegationSpecification<T>(this);
	}
	
	/**
	 * Returns this specification as predicate.
	 * 
	 * @return The specification as predicate.
	 */
	default Predicate<T> toPredicate() {
		return  (candidate) -> isSatisfiedBy(candidate);
	}
}