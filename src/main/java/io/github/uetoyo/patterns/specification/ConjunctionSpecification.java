package io.github.uetoyo.patterns.specification;

/* 
 * Conjunction specification represents the logical AND.
 */
public class ConjunctionSpecification<T> extends CompositeSpecification<T> {
	
	public ConjunctionSpecification(Specification<T> first, Specification<T> second) {
		super(first, second);
	}
	
	public boolean isSatisfiedBy(T candidate) {
		return getFirst().isSatisfiedBy(candidate) && getSecond().isSatisfiedBy(candidate);
	}
}
