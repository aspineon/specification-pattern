package io.github.uetoyo.patterns.specification;

import java.util.function.Predicate;

import io.github.uetoyo.patterns.specification.protocols.Factory;

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
	 * Returns the new disjunction specification composed from this and other specification.
	 * 
	 * @param other The right-hand side specification.
	 * @return The new disjunction specification.
	 */
	default Specification<T> or(final Specification<T> other) {
		return new DisjunctionSpecification<T>(this, other);
	}

	/**
	 * Returns the new conjunction specification composed from this and other specification.
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
	
	/* TODO
	 * Creates the specification for specified class.
	 * All objects which are instances of that class or subclass satisfied this specification.
	 * 
	 * @param clazz
	 */
	//static void createSpecificationFor(Class<?> type) {}
	
	/**
	 * Creates the always false specification for the given type.
	 * 
	 * @return The always false specification.
	 */
	@Factory
	static <T> AlwaysFalseSpecification<T> createAlwaysFalseSpecification() {
		return new AlwaysFalseSpecification<T>();
	}
	
	/**
	 * Creates the always false specification for the given type.
	 * 
	 * @return The always true specification.
	 */
	@Factory
	static <T> AlwaysTrueSpecification<T> createAlwaysTrueSpecification() {
		return new AlwaysTrueSpecification<T>();
	}
	
	/**
	 * Creates the conjunction specification.
	 * 
	 * @param spec1 The left-hand side specification.
	 * @param spec2 The right-hand side specification.
	 * @return The new conjunction specification.
	 */
	@Factory
	static <T> ConjunctionSpecification<T> createConjunctionSpecification(
			Specification<T> spec1, Specification<T> spec2) {
		return new ConjunctionSpecification<T>(spec1, spec2);
	}
	
	/**
	 * Creates the disjunction specification.
	 * 
	 * @param spec1 The left-hand side specification.
	 * @param spec2 The right-hand side specification.
	 * @return The new disjunction specification.
	 */
	@Factory
	static <T> DisjunctionSpecification<T> createDisjunctionSpecification(
			Specification<T> spec1, Specification<T> spec2) {
		return new DisjunctionSpecification<T>(spec1, spec2);
	}
	
	/**
	 * Creates the negation specification.
	 * 
	 * @param spec The inner specification.
	 * @return The new negation specification.
	 */
	@Factory
	static <T> NegationSpecification<T> createNegationSpecification(Specification<T> spec) {
		return new NegationSpecification<T>(spec);
	}
}