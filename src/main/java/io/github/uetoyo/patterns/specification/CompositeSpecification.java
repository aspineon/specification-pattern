package io.github.uetoyo.patterns.specification;

import java.util.UUID;

/**
 * Představuje kompozitní specifikaci, tj. takovou, kterou lze kombinovat.
 * 
 * @param <T>
 */
public abstract class CompositeSpecification<T> extends AbstractSpecification<T> {
	
	private final Specification<T> first;
	private final Specification<T> second;
	
	/**
	 * Creates a new composite specification with a given id.
	 *
	 * @param uniqueId
	 * @param first The first specification (left-hand side).
	 * @param second The second specification (right-hand side).
	 */
	protected CompositeSpecification(UUID uniqueId, Specification<T> first, Specification<T> second) {
		super(uniqueId);
		this.first = first;
		this.second = second;
	}
	
	/**
	 * Creates a new composite specification with an auto generated id.
	 * 
	 * @param first The first specification (left-hand side).
	 * @param second The second specification (right-hand side).
	 */
	protected CompositeSpecification(Specification<T> first, Specification<T> second) {
		this(UUID.randomUUID(), first, second);
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
