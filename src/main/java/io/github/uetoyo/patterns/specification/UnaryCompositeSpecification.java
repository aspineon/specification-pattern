package io.github.uetoyo.patterns.specification;

public abstract class UnaryCompositeSpecification<T> implements Specification<T> {
	
	private final Specification<T> spec;
	
	/**
	 * The unary composite specification.
	 * 
	 * @param spec The inner specification.
	 */
	protected UnaryCompositeSpecification(final Specification<T> spec) {
		if (spec == null) {
			throw new IllegalArgumentException("The `null` value is not allowed!");
		}
		this.spec = spec;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public abstract boolean isSatisfiedBy(final T candidate);
	
	/**
	 * Gets the inner specification.
	 * 
	 * @return The inner specification.
	 */
	public Specification<T> getSpecification() {
		return spec;
	}
}
