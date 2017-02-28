package io.github.uetoyo.patterns.specification;

/**
 * This is the specification which always returns `true`.
 * 
 * @param <T> The type of entity for which the specification is defined.
 */
public class AlwaysTrueSpecification<T> implements Specification<T> {
	
	@Override
	public boolean isSatisfiedBy(Object candidate) {
		return true;
	}
}
