package io.github.uetoyo.patterns.specification;

import io.github.uetoyo.patterns.specification.AlwaysFalseSpecification;
import io.github.uetoyo.patterns.specification.AlwaysTrueSpecification;
import io.github.uetoyo.patterns.specification.Specification;

/*
 * The base class for all composite specification tests.
 */
public class SpecificationTestBase {
	
	protected final AlwaysTrueSpecification<Object> ts = 
			Specification.<Object>createAlwaysTrueSpecification();
	
	protected final AlwaysFalseSpecification<Object> fs = 
			Specification.<Object>createAlwaysFalseSpecification();
}
