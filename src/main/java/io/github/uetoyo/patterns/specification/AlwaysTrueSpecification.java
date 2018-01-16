package io.github.uetoyo.patterns.specification;

import java.util.Objects;

/**
 * This is the specification which always returns `true`.
 * 
 * @param <T> The type of entity for which the specification is defined.
 */
final class AlwaysTrueSpecification<T> extends NullaryCompositeSpecification<T> {

	private final static AlwaysTrueSpecification<?> INSTANCE = new AlwaysTrueSpecification<>();

	private AlwaysTrueSpecification() {}

	static AlwaysTrueSpecification<?> instance() {
		return INSTANCE;
	}
	@Override
	public boolean isSatisfiedBy(Object candidate) {
		return true;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof AlwaysTrueSpecification<?>) ? true : false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(getClass());
	}
}
