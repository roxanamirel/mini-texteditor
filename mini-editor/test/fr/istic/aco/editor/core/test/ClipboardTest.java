package fr.istic.aco.editor.core.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.core.Clipboard;
import fr.istic.aco.editor.core.impl.ClipboardImpl;

/**
 * The Class ClipboardTest.
 */
public class ClipboardTest {
	
	/** The clipboard. */
	private Clipboard clipboard;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		clipboard = new ClipboardImpl();
	}

	/**
	 * Test read after write.
	 */
	@Test
	public void testReadAfterWrite() {
		String text = "clipTest";
		clipboard.write(text);
		assertEquals(text, clipboard.read());
	}

}
