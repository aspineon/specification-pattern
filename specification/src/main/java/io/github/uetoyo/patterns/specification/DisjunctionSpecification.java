package io.github.uetoyo.patterns.specification;

/* 
 * Conjunction specification represents the logical OR.
 */
public class DisjunctionSpecification<T> extends CompositeSpecification<T> {
	
	public DisjunctionSpecification(Specification<T> first, Specification<T> second) {
		super(first, second);
	}
	
	public boolean isSatisfiedBy(T candidate) {
		return getFirst().isSatisfiedBy(candidate) || getSecond().isSatisfiedBy(candidate);
	}
}
