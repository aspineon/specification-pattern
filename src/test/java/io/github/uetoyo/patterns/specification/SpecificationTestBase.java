package io.github.uetoyo.patterns.specification;

/*
 * The base class for all composite specification tests.
 */
public class SpecificationTestBase {

	protected final AlwaysTrueSpecification ts = new AlwaysTrueSpecification();
	protected final AlwaysFalseSpecification fs = new AlwaysFalseSpecification();
	
}
