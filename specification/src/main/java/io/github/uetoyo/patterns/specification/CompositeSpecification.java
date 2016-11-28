package io.github.uetoyo.patterns.specification;


/**
 * Představuje kompozitní specifikaci, tj. takovou, kterou lze kombinovat.
 * 
 * @param <T>
 */
public abstract class CompositeSpecification<T> implements Specification<T >{
	
	private final Specification<T> first;
	private final Specification<T> second;
	
	protected CompositeSpecification(Specification<T> first, Specification<T> second) {
		this.first = first;
		this.second = second;
	}
	
	Specification<T> or(Specification<T> specification) {
		return new DisjunctionSpecification<T>(this, specification);
	}
	
	Specification<T> and(Specification<T> specification) {
		return new ConjunctionSpecification<T>(this, specification);
	}
	
	Specification<T> not(Specification<T> specification) {
		return new NegationSpecification<T>(specification);
	}
	
	public Specification<T> getFirst() {
		return first;
	}
	
	public Specification<T> getSecond() {
		return second;
	}
	
}
