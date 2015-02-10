package fr.istic.aco.editor.core.command.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.core.MiniEditorEngine;
import fr.istic.aco.editor.core.command.Cut;
import fr.istic.aco.editor.core.impl.BufferImpl;
import fr.istic.aco.editor.core.impl.SelectionImpl;

/**
 * The Class CutTest.
 */
public class CutTest {

	/** The cut. */
	private Cut cut;
	
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
		when(mockedEditorEngine.getBuffer()).thenReturn(new BufferImpl());
		when(mockedEditorEngine.getSelection()).thenReturn(new SelectionImpl());
		cut = new Cut(mockedEditorEngine);
	}

	/**
	 * Test execute.
	 */
	@Test
	public void testExecute() {
		cut.execute();
		verify(mockedEditorEngine).engineCut();
	}

}
