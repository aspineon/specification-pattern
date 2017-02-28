package io.github.uetoyo.patterns.specification;

import java.util.Objects;

/**
 * This is the specification which always returns `false`.
 * 
 * @param <T> The type of entity for which the specification is defined.
 */
public class AlwaysFalseSpecification<T> implements Specification<T> {
	
	protected AlwaysFalseSpecification() { }
	
	@Override
	public boolean isSatisfiedBy(T candidate) {
		return false;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof AlwaysFalseSpecification<?>) ? true : false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getClass());
	}
}
