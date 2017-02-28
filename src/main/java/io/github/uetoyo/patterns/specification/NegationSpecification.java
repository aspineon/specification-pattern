package io.github.uetoyo.patterns.specification;

/**
 * The negation specification.
 *
 * @param <T> The entity type for which the specification is defined.
 */
final class NegationSpecification<T> extends UnaryCompositeSpecification<T> {
	
	public NegationSpecification(final Specification<T> specification) {
		super(specification);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSatisfiedBy(final T candidate) {
		return ! getSpecification().isSatisfiedBy(candidate);
	}
}
