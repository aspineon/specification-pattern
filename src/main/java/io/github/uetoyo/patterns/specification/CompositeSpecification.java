package io.github.uetoyo.patterns.specification;


/**
 * Composite specification.
 * 
 * @param <T>
 */
public abstract class CompositeSpecification<T> implements Specification<T> {
	
	protected final Specification<T> spec1;
	protected final Specification<T> spec2;
	
	/**
	 * Creates a new composite specification.
	 *
	 * @param uniqueId
	 * @param first The first specification (left-hand side).
	 * @param second The second specification (right-hand side).
	 */
	protected CompositeSpecification(final Specification<T> spec1, final Specification<T> spec2) {
		this.spec1 = spec1;
		this.spec2 = spec2;
	}
	
	Specification<T> or(Specification<T> other) {
		return new DisjunctionSpecification<T>(this, other);
	}
	
	Specification<T> and(Specification<T> other) {
		return new ConjunctionSpecification<T>(this, other);
	}
	
	Specification<T> not(Specification<T> other) {
		return new NegationSpecification<T>(other);
	}	
	
	 /**
	  * {@inheritDoc}
	  */
	 public abstract boolean isSatisfiedBy(T t);
}
