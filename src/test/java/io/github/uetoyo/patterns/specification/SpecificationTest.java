package io.github.uetoyo.patterns.specification;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import io.github.uetoyo.patterns.specification.AlwaysFalseSpecification;
import io.github.uetoyo.patterns.specification.AlwaysTrueSpecification;
import io.github.uetoyo.patterns.specification.ConjunctionSpecification;
import io.github.uetoyo.patterns.specification.DisjunctionSpecification;
import io.github.uetoyo.patterns.specification.NegationSpecification;
import io.github.uetoyo.patterns.specification.Specification;

public class SpecificationTest extends SpecificationTestBase {
	
	@Test
	public void shouldCreateAlwaysFalseSpecificaton() {
		assertThat(Specification.<Object>createAlwaysFalseSpecification(), 
				instanceOf(AlwaysFalseSpecification.class));
	}
	
	@Test
	public void shouldCreateAlwaysTrueSpecificaton() {
		assertThat(Specification.<Object>createAlwaysTrueSpecification(), 
				instanceOf(AlwaysTrueSpecification.class));
	}

	@Test
	public void shouldCreateConjunctionSpecificaton() {
		assertThat(Specification.<Object>createConjunctionSpecification(ts, ts), 
				instanceOf(ConjunctionSpecification.class));
	}

	@Test
	public void shouldCreateDisjunctionSpecificaton() {
		assertThat(Specification.<Object>createDisjunctionSpecification(ts, ts), 
				instanceOf(DisjunctionSpecification.class));
	}
	
	@Test
	public void shouldCreateNegationSpecificaton() {
		assertThat(Specification.<Object>createNegationSpecification(ts), 
				instanceOf(NegationSpecification.class));
	}
}
