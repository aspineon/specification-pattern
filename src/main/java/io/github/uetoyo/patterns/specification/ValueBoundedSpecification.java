package io.github.uetoyo.patterns.specification;

import com.google.common.annotations.Beta;

@Beta
abstract class ValueBoundedSpecification<T, V> implements Specification<T> {
	
	private final V value;

	/* TODO
	public static <T, V> EqualValueSpecification<T, V> withEqualValue(V value) {
		return new EqualValueSpecification<T, V>(value); 
	}*/
	
	protected ValueBoundedSpecification(V value) {
		this.value = value;
	}

	public V getValue() {
		return value;
	}
}
