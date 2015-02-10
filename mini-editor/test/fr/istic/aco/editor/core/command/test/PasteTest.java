package fr.istic.aco.editor.core.command.test;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.core.MiniEditorEngine;
import fr.istic.aco.editor.core.command.Paste;
import fr.istic.aco.editor.core.impl.BufferImpl;
import fr.istic.aco.editor.core.impl.SelectionImpl;

/**
 * The Class PasteTest.
 */
public class PasteTest {

	/** The paste. */
	private Paste paste;
	
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
		paste = new Paste(mockedEditorEngine);
	}

	/**
	 * Test execute.
	 */
	@Test
	public void testExecute() {
		paste.execute();
		verify(mockedEditorEngine).enginePaste();
	}

}
