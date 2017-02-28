package io.github.uetoyo.patterns.specification;

/**
 * This is the specification which always returns `false`.
 * 
 * @param <T> The type of entity for which the specification is defined.
 */
public class AlwaysFalseSpecification<T> implements Specification<T> {
	
	@Override
	public boolean isSatisfiedBy(T candidate) {
		return false;
	}
}
