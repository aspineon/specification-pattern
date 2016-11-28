package io.github.uetoyo.patterns.specification;

public class NegationSpecification<T> implements Specification<T> {
	
	Specification<T> specification; 
	
	protected NegationSpecification(Specification<T> specification) {
		this.specification = specification;
	}

	public boolean isSatisfiedBy(T candidate) {
		return !specification.isSatisfiedBy(candidate);
	}
}
