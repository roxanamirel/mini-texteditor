package fr.istic.aco.editor.core.command.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.core.MiniEditorEngine;
import fr.istic.aco.editor.core.command.Insert;
import fr.istic.aco.editor.core.impl.BufferImpl;
import fr.istic.aco.editor.core.impl.SelectionImpl;

/**
 * The Class InsertTest.
 */
public class InsertTest {

	/** The insert. */
	private Insert insert;

	/** The mocked editor engine. */
	private MiniEditorEngine mockedEditorEngine;
	
	/** The test string. */
	private final String TEST_STRING = "testString";

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
		insert = new Insert(mockedEditorEngine, TEST_STRING);
	}

	/**
	 * Test execute.
	 */
	@Test
	public void testExecute() {
		insert.execute();
		verify(mockedEditorEngine).engineInsert(TEST_STRING);
	}

}
