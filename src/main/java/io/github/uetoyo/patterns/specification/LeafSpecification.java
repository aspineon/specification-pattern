package io.github.uetoyo.patterns.specification;

import java.util.UUID;

public abstract class LeafSpecification<T> extends AbstractSpecification<T> {
	
	private final Specification<T> specification;
	
	protected LeafSpecification(UUID uniqueId, Specification<T> specification) {
		this(specification);
	}
	
	protected LeafSpecification(Specification<T> specification) {
		super(UUID.randomUUID());
		this.specification = specification;
	}
	
	public Specification<T> getSpecification() {
		return specification;
	}
}
