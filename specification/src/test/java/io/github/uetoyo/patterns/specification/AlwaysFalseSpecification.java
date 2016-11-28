package io.github.uetoyo.patterns.specification;

/*
 * This is the helper class which always returns `true`.
 */
public class AlwaysFalseSpecification implements Specification<Object> {

	public boolean isSatisfiedBy(Object candidate) {
		return false;
	}
}
