package io.github.uetoyo.patterns.specification;

/* 
 * Conjunction specification represents the logical AND.
 */
public final class ConjunctionSpecification<T> extends CompositeSpecification<T> {
	
	public ConjunctionSpecification(final Specification<T> spec1, final Specification<T> spec2) {
		super(spec1, spec2);
	}
	
	public boolean isSatisfiedBy(final T candidate) {
		return spec1.isSatisfiedBy(candidate) && spec2.isSatisfiedBy(candidate);
	}
}
