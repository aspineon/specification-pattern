package io.github.uetoyo.patterns.specification;

/**
 * Specification interface.
 * 
 * @param <T> the domain entity type
 */
public interface Specification<T> {

	/**
	 * Check if the {@code candidate} is satisfied by the specification.
	 *
	 * @param candidate an object to test.
	 * @return {@code true} if the candidate satisfies the specification otherwise {@code false}
	 */ 
	boolean isSatisfiedBy(T candidate);
}