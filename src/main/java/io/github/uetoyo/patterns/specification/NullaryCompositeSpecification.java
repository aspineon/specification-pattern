package io.github.uetoyo.patterns.specification;

import io.github.uetoyo.patterns.specification.protocols.Immutable;

/**
 * The specification without any component.
 *
 * @param <T> The type of entity for which the specification is defined.
 */
@Immutable
abstract class NullaryCompositeSpecification<T> implements Specification<T> {
	
}
