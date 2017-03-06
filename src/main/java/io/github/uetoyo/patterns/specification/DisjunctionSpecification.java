package io.github.uetoyo.patterns.specification;

import io.github.uetoyo.patterns.specification.protocols.Immutable;

/**
 * Conjunction specification represents the logical OR.
 *
 * @param <T> The type of entity for which the specification is defined.
 */
@Immutable
final class DisjunctionSpecification<T> extends BinaryCompositeSpecification<T> {
	
	public DisjunctionSpecification(final Specification<T> spec1, final Specification<T> spec2) {
		super(spec1, spec2);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isSatisfiedBy(final T candidate) {
		return getSpecificationOne().isSatisfiedBy(candidate) || getSpecificationTwo().isSatisfiedBy(candidate);
	}
}
