package fr.istic.aco.editor.core.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.core.Selection;
import fr.istic.aco.editor.core.impl.SelectionImpl;

/**
 * The Class SelectionTest.
 */
public class SelectionTest {
	
	/** The selection. */
	private Selection selection;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		selection = new SelectionImpl();
	}
	
	/**
	 * Test begin.
	 */
	@Test
	public void testBegin() {
		int begin = 5;
		selection.setBegin(begin);
		assertEquals(begin, selection.getBegin());
	}
	
	/**
	 * Test end.
	 */
	@Test
	public void testEnd() {
		int end = 5;
		selection.setEnd(end);
		assertEquals(end, selection.getEnd());
	}
	
	/**
	 * Test length.
	 */
	@Test
	public void testLength() {
		int end = 50;
		int begin = 5;
		selection.setBegin(begin);
		selection.setEnd(end);
		int expected = end - begin;
		assertEquals(expected, selection.getLength());
	}

}
