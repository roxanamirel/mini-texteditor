package fr.istic.aco.editor.core.command.test;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.core.MiniEditorEngine;
import fr.istic.aco.editor.core.command.Select;

/**
 * The Class SelectTest.
 */
public class SelectTest {
	
	/** The select. */
	private Select select;
	
	/** The mocked editor engine. */
	private MiniEditorEngine mockedEditorEngine;	
	
	/** The start. */
	private final int START = (int) (Math.random() * 100);
	
	/** The end. */
	private final int END = (int) (Math.random() * 100);
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		mockedEditorEngine = mock(MiniEditorEngine.class);
		select = new Select(mockedEditorEngine, START, END);
	}

	/**
	 * Test execute.
	 */
	@Test
	public void testExecute() {
		select.execute();
		verify(mockedEditorEngine).engineSelect(START, END);
	}

}
