package io.github.uetoyo.patterns.specification;

/**
 * Specification interface.
 * 
 * @param <T> the domain entity type
 */
public interface Specification<T> {

	boolean isSatisfiedBy(T candidate);
}