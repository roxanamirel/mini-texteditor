package fr.istic.aco.editor.core.command.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.core.MiniEditorEngine;
import fr.istic.aco.editor.core.command.Copy;

/**
 * The Class CopyTest.
 */
public class CopyTest {

	/** The copy. */
	private Copy copy;

	/** The mocked editor engine. */
	private MiniEditorEngine mockedEditorEngine;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		mockedEditorEngine = mock(MiniEditorEngine.class);
		copy = new Copy(mockedEditorEngine);
	}

	/**
	 * Test execute.
	 */
	@Test
	public void testExecute() {
		copy.execute();
		verify(mockedEditorEngine).engineCopy();
	}

}
