package io.github.uetoyo.patterns.specification;

/* 
 * Conjunction specification represents the logical OR.
 */
public final class DisjunctionSpecification<T> extends BinaryCompositeSpecification<T> {
	
	public DisjunctionSpecification(final Specification<T> spec1, final Specification<T> spec2) {
		super(spec1, spec2);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public boolean isSatisfiedBy(final T candidate) {
		return getSpecificationOne().isSatisfiedBy(candidate) || getSpecificationTwo().isSatisfiedBy(candidate);
	}
}
