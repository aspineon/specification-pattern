package io.github.uetoyo.patterns.specification;

public class NegationSpecification<T> implements Specification<T> {
	
	protected final Specification<T> spec; 
	
	public NegationSpecification(Specification<T> spec) {
		if (spec == null) {
			throw new IllegalArgumentException("The `null` value is not allowed!");
		}
		this.spec = spec;
	}
	
	public boolean isSatisfiedBy(T candidate) {
		return !spec.isSatisfiedBy(candidate);
	}
	
}
