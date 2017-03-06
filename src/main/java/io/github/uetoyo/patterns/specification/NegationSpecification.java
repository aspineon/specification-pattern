package io.github.uetoyo.patterns.specification;

import io.github.uetoyo.patterns.specification.protocols.Immutable;

/**
 * The negation specification.
 *
 * @param <T> The entity type for which the specification is defined.
 */
@Immutable
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
