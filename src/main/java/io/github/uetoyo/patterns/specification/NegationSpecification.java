package io.github.uetoyo.patterns.specification;

import java.util.UUID;

public class NegationSpecification<T> implements Specification<T> {
	
	protected final Specification<T> spec; 
	
	public NegationSpecification(UUID uniqueId, Specification<T> spec) {
		this(spec);
	}
	
	public NegationSpecification(Specification<T> spec) {
		this.spec = spec;
	}
	
	public boolean isSatisfiedBy(T candidate) {
		return !spec.isSatisfiedBy(candidate);
	}
	
}
