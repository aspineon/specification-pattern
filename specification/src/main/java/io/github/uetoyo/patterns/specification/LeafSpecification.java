package io.github.uetoyo.patterns.specification;

public abstract class LeafSpecification<T> implements Specification<T> {
	
	private final Specification<T> specification;
	
	public LeafSpecification(Specification<T> specification) {
		this.specification = specification;
	}
	
	public Specification<T> getSpecification() {
		return specification;
	}
}
