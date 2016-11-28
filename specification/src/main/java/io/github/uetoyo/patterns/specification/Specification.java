package io.github.uetoyo.patterns.specification;

/**
 * Specification
 * @param <T> domain entity type
 */
public interface Specification<T> {
	
	boolean isSatisfiedBy(T candidate);
}