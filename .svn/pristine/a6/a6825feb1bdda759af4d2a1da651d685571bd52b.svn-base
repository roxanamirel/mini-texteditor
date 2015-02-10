package fr.istic.aco.editor.core.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.core.Buffer;
import fr.istic.aco.editor.core.impl.BufferImpl;

/**
 * The Class BufferTest.
 */
public class BufferTest {
	
	/** The buffer. */
	private Buffer buffer;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		buffer = new BufferImpl();
	}

	/**
	 * Test read after write.
	 */
	@Test
	public void testReadAfterWrite() {
		int begin = 2;
		int end = 5;
		String text = "testing the buffer";
		buffer.write(0, text.length(), text);
		assertEquals(text, buffer.read(0, text.length()));
		String resultText = buffer.read(begin, end);
		assertEquals(text.substring(begin, end), resultText);
	}

}
