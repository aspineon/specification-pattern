package io.github.uetoyo.patterns.specification;

public abstract class LeafSpecification<T> implements Specification<T> {
	
	protected final Specification<T> spec;
	
	protected LeafSpecification(Specification<T> spec) {
		this.spec = spec;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public abstract boolean isSatisfiedBy(final T candidate);
}
