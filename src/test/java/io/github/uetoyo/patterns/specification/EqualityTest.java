package io.github.uetoyo.patterns.specification;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EqualityTest extends SpecificationTestBase {
	
	@Test public void alwaysTrueSpecificationsShouldBeEqual() {
		assertTrue(ts.equals(ts));
	}
	
	@Test public void alwaysFalseSpecificationsShouldBeEqual() {
		assertTrue(fs.equals(fs));
	}

	@Test public void alwaysTrueAndFalseSpecificationsShouldBeNotEqual() {
		assertFalse(ts.equals(fs));
		assertFalse(fs.equals(ts));
		assertFalse(fs.hashCode() == ts.hashCode());
	}
}
