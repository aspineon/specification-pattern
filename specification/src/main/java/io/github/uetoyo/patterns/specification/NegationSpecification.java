package io.github.uetoyo.patterns.specification;

import java.util.UUID;

public class NegationSpecification<T> extends AbstractSpecification<T> {
	
	Specification<T> specification; 
	
	protected NegationSpecification(UUID uniqueId, Specification<T> specification) {
		this(specification);
	}
	
	protected NegationSpecification(Specification<T> specification) {
		super(UUID.randomUUID());
		this.specification = specification;
	}

	public boolean isSatisfiedBy(T candidate) {
		return !specification.isSatisfiedBy(candidate);
	}
}
