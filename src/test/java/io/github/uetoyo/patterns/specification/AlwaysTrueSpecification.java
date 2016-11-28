package io.github.uetoyo.patterns.specification;

import java.util.UUID;

/*
 * This is the helper class which always returns `true`.
 */
public class AlwaysTrueSpecification extends AbstractSpecification<Object> {

	AlwaysTrueSpecification() {
		super(UUID.randomUUID());
	}
	
	public boolean isSatisfiedBy(Object candidate) {
		return true;
	}
}
