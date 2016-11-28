package io.github.uetoyo.patterns.specification;

import java.util.UUID;

/*
 * This is the helper class which always returns `true`.
 */
public class AlwaysFalseSpecification extends AbstractSpecification<Object> {

	public AlwaysFalseSpecification() {
		super(UUID.randomUUID());
	}

	public boolean isSatisfiedBy(Object candidate) {
		return false;
	}
}
