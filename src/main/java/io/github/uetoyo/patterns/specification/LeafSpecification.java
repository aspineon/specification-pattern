package io.github.uetoyo.patterns.specification;

public abstract class LeafSpecification<T> implements Specification<T> {
	
	protected final Specification<T> spec;
	
	protected LeafSpecification(Specification<T> spec) {
		if (spec == null) {
			throw new IllegalArgumentException("The `null` value is not allowed!");
		}
		this.spec = spec;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public abstract boolean isSatisfiedBy(final T candidate);
}
