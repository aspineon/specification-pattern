package io.github.uetoyo.patterns.specification;

import java.util.UUID;

public abstract class AbstractSpecification<T> implements Specification<T> {
	
	private final UUID uniqueId;
	
	public AbstractSpecification(UUID uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	public UUID getUniqueId() {
		return uniqueId;
	}
}
