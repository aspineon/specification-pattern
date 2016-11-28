package io.github.uetoyo.patterns.specification;

import junit.framework.TestCase;

/*
 * The base class for all composite specification tests.
 */
public class CompositeSpecificationTest extends TestCase {

	protected final AlwaysTrueSpecification ts = new AlwaysTrueSpecification();
	protected final AlwaysFalseSpecification fs = new AlwaysFalseSpecification();
	
}
