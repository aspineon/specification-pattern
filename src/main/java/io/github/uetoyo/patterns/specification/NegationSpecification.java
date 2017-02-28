package io.github.uetoyo.patterns.specification;

/**
 * The negation specification.
 *
 * @param <T> The entity type for which the specification is defined.
 */
public final class NegationSpecification<T> extends UnaryCompositeSpecification<T> {
	
	public NegationSpecification(final Specification<T> specification) {
		super(specification);
	}
	
	public boolean isSatisfiedBy(final T candidate) {
		return ! getSpecification().isSatisfiedBy(candidate);
	}
}
