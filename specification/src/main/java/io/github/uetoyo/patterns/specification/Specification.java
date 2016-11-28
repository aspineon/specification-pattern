package io.github.uetoyo.patterns.specification;

import java.util.UUID;

/**
 * Specification
 * 
 * @param <T> domain entity type
 */
public interface Specification<T> {
	
	UUID getUniqueId();
	
	/**
	 * {@inheritDoc}
	 */
	boolean isSatisfiedBy(T candidate);
}