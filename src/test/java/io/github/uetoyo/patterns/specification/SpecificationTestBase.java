package io.github.uetoyo.patterns.specification;

/*
 * The base class for all composite specification tests.
 */
public class SpecificationTestBase {

	protected final AlwaysTrueSpecification<Object> ts = new AlwaysTrueSpecification<Object>();
	protected final AlwaysFalseSpecification<Object> fs = new AlwaysFalseSpecification<Object>();
	
}
