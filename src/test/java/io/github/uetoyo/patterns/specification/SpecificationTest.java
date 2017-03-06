package io.github.uetoyo.patterns.specification;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class SpecificationTest {
	
	private final AlwaysTrueSpecification<Object> ts = 
			Specification.<Object>createAlwaysTrueSpecification();
	
	private final AlwaysFalseSpecification<Object> fs = 
			Specification.<Object>createAlwaysFalseSpecification();
	
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
	
	// Static factory methods
	
	@Test public void shouldCreateAlwaysFalseSpecificaton() {
		assertThat(Specification.<Object>createAlwaysFalseSpecification(), 
				instanceOf(AlwaysFalseSpecification.class));
	}
	
	@Test public void shouldCreateAlwaysTrueSpecificaton() {
		assertThat(Specification.<Object>createAlwaysTrueSpecification(), 
				instanceOf(AlwaysTrueSpecification.class));
	}
	
	@Test public void shouldCreateNegationSpecificaton() {
		assertThat(Specification.<Object>createNegationSpecification(ts), 
				instanceOf(NegationSpecification.class));
	}
	
	@Test public void shouldReturnTrueForMultiaryConjuctionSpecification() {
		assertTrue(Specification.<Object>all(ts, ts).isSatisfiedBy(new Object()));
		assertTrue(Specification.<Object>all(ts, ts, ts).isSatisfiedBy(new Object()));
	}
	
	@Test public void shouldReturnFalseForMultiaryConjuctionSpecification() {
		assertFalse(Specification.<Object>all(ts, fs).isSatisfiedBy(new Object()));
		assertFalse(Specification.<Object>all(ts, ts, fs).isSatisfiedBy(new Object()));
	}
	
	@Test public void shouldReturnTrueForMultiaryDisjuctionSpecification() {
		assertTrue(Specification.<Object>any(ts, fs).isSatisfiedBy(new Object()));
		assertTrue(Specification.<Object>any(ts, fs, fs).isSatisfiedBy(new Object()));
	}
	
	@Test public void shouldReturnFalseForMultiaryDisjuctionSpecification() {
		assertFalse(Specification.<Object>any(fs, fs).isSatisfiedBy(new Object()));
		assertFalse(Specification.<Object>any(fs, fs, fs).isSatisfiedBy(new Object()));
	}
	
	// Negation
	
	@Test public void testThatNegationReturnsFalse() {
		NegationSpecification<Object> spec = new NegationSpecification<>(ts);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	@Test public void testThatNegationReturnsTrue() {
		NegationSpecification<Object> spec = new NegationSpecification<>(fs);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/* 
	 * True AND True = True
	 */
	@Test public void testThatConjunctionReturnsTrueForTrueAndTrueSpecification() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<>(ts, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * True AND False = False
	 */
	@Test public void testThatConjunctionReturnsFalseForTrueAndFalseSpecification() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<>(ts, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False AND True = False
	 */
	@Test public void testThatConjunctionReturnsFalseForFalseAndTrueSpecification() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<>(fs, ts);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False AND False = False
	 */
	@Test public void testThatConjunctionReturnsFalseForFalseAndFalseSpecification() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<>(fs, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * To predicate conversion.
	 */
	@Test public void shouldReturnSpecificationAsPredicate() {
		ConjunctionSpecification<Object> spec = new ConjunctionSpecification<>(ts, ts);
		assertTrue(spec.toPredicate().test(new Object()));
	}
	
	/* 
	 * True OR True = True
	 */
	@Test public void testThatDisjunctionReturnsTrueForTrueOrTrueSpecification() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<>(ts, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * True OR False = True
	 */
	@Test public void testThatDisjunctionReturnsTrueForTrueOrFalseSpecification() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<>(ts, fs);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False OR True = True
	 */
	@Test public void testThatDisjunctionReturnsTrueForFalseOrTrueSpecification() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<>(fs, ts);
		assertTrue(spec.isSatisfiedBy(new Object()));
	}
	
	/*
	 * False AND False = False
	 */
	@Test public void testThatDisjunctionReturnsFalseForFalseOrFalseSpecification() {
		DisjunctionSpecification<Object> spec = new DisjunctionSpecification<>(fs, fs);
		assertFalse(spec.isSatisfiedBy(new Object()));
	}
	
	@Test public void shouldReturnUnsatisfiedSpecification() {
		CompositeSpecification<Object> spec = new ConjunctionSpecification<Object>(ts, fs);
		Set<Specification<Object>> unsatisfiedSpecs  = spec.getUnsatisfiedSpecificationsFor(new Object());
		assertTrue(unsatisfiedSpecs.size() == 1);
	}
	
	@Test public void shouldReturnOnlyOneUnsatisfiedSpecificationIfTheAreOfSameType() {
		CompositeSpecification<Object> spec = new ConjunctionSpecification<Object>(fs, fs);
		Set<Specification<Object>> unsatisfiedSpecs  = spec.getUnsatisfiedSpecificationsFor(new Object());
		assertTrue(unsatisfiedSpecs.size() == 1);
	}
}
