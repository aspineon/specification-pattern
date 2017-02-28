package io.github.uetoyo.patterns.specification;

/* 
 * Conjunction specification represents the logical AND.
 */
public final class ConjunctionSpecification<T> extends BinaryCompositeSpecification<T> {
	
	public ConjunctionSpecification(final Specification<T> spec1, final Specification<T> spec2) {
		super(spec1, spec2);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean isSatisfiedBy(final T candidate) {
		return getSpecificationOne().isSatisfiedBy(candidate) && getSpecificationTwo().isSatisfiedBy(candidate);
	}
}
