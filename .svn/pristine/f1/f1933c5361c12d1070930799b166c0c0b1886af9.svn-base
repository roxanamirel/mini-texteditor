package fr.istic.aco.editor.core.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.MiniEditor;
import fr.istic.aco.editor.core.impl.MiniEditorImpl;

/**
 * The Class MiniEditorTest.
 */
public class MiniEditorTest {

	/** The mini editor. */
	private MiniEditor miniEditor;

	/** The test1. */
	final String test1 = "test1";
	
	/** The test2. */
	final String test2 = "test2";
	
	/** The test3. */
	final String test3 = "test3";
	
	/** The short text. */
	final String shortText = "st";

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		miniEditor = new MiniEditorImpl();
	}

	/**
	 * Test several chained commands.
	 */
	@Test
	public void testSeveralChainedCommands() {

		miniEditor.editorInsert(test1);
		// buffer should be = "test1"
		assertEquals(test1, miniEditor.getBuffer());

		miniEditor.editorInsert(test2);
		// buffer should be = "test2test1"
		assertEquals(test2.concat(test1), miniEditor.getBuffer());

		int start = 0;
		int stop = 5;
		miniEditor.editorSelect(start, stop);
		// selection should be = "test2"
		assertEquals(test2, miniEditor.getSelection());

		miniEditor.editorCut();
		// clipboard should be = test2
		assertEquals(test2, miniEditor.getClipboard());
		// buffer should be = test1
		assertEquals(test1, miniEditor.getBuffer());

		start = 5;
		stop = 5;
		miniEditor.editorSelect(start, stop);
		// selection should be = ""
		assertEquals("", miniEditor.getSelection());
		
		miniEditor.editorPaste();
		// buffer should be = "test1test2"
		assertEquals(test1.concat(test2), miniEditor.getBuffer());

		miniEditor.editorPaste();
		// buffer should be = "test1test2test2"
		assertEquals(test1.concat(test2).concat(test2), miniEditor.getBuffer());

		start = 5;
		stop = 10;
		miniEditor.editorSelect(start, stop);
		// selection should be = "test2"
		assertEquals(test2, miniEditor.getSelection());

		miniEditor.editorInsert(shortText);
		// buffer should be = "test2sttest1"
		assertEquals(test1.concat(shortText).concat(test2),
				miniEditor.getBuffer());
	}

	/**
	 * Should undo all commands.
	 */
	@Test
	public void shouldUndoAllCommands() {
		repeatCommandsFromTestSeveralChainedCommands();
		undoAll();
		assertEquals("", miniEditor.getBuffer());
	}

	/**
	 * Should undo half of commands.
	 */
	@Test
	public void shouldUndoHalfOfCommands() {
		repeatCommandsFromTestSeveralChainedCommands();

		int totalUndoable = 6 / 2;
		for (int i = 0; i < totalUndoable; i++) {
			miniEditor.editorUndo();
		}
		// clipboard should be = test2
		assertEquals(test2, miniEditor.getClipboard());
		// buffer should be = test1
		assertEquals(test1, miniEditor.getBuffer());
	}

	/**
	 * Should redo all undone commands.
	 */
	@Test
	public void shouldRedoAllUndoneCommands() {
		repeatCommandsFromTestSeveralChainedCommands();
		System.out.println("\nundoeing\n");
		undoAll();
		System.out.println("\nredoing\n");
		redoAll();
		// buffer should be = "test2sttest1"
		assertEquals(test1.concat(shortText).concat(test2),
				miniEditor.getBuffer());
	}

	/**
	 * Redo all.
	 */
	private void redoAll() {
		int totalUndoed = 6;
		for (int i = 0; i < totalUndoed; i++) {
			miniEditor.editorRedo();
		}

	}

	/**
	 * Undo all.
	 */
	private void undoAll() {

		int totalUndoable = 6;
		for (int i = 0; i < totalUndoable; i++) {
			miniEditor.editorUndo();
		}

	}

	/**
	 * Repeat commands from test several chained commands.
	 */
	private void repeatCommandsFromTestSeveralChainedCommands() {
		miniEditor.editorInsert(test1);
		miniEditor.editorInsert(test2);

		int start = 0;
		int stop = 5;
		miniEditor.editorSelect(start, stop);

		miniEditor.editorCut();

		start = 5;
		stop = 5;
		miniEditor.editorSelect(start, stop);

		miniEditor.editorPaste();

		miniEditor.editorPaste();

		start = 5;
		stop = 10;
		miniEditor.editorSelect(start, stop);

		String shortText = "st";
		miniEditor.editorInsert(shortText);

	}
	/**
	 * Copy, paste, then undo and then redo
	 */
	@Test
	public void editorCopyAndPasteThenUndoRedoTest() {
		miniEditor.editorInsert(test2);
		miniEditor.editorSelect(0, test2.length());
		miniEditor.editorCopy();
		miniEditor.editorSelect(5, 10);
		miniEditor.editorPaste();
		assertEquals(test2.concat(test2),
				miniEditor.getBuffer());
		miniEditor.editorUndo();
		assertEquals(test2,
				miniEditor.getBuffer());
		miniEditor.editorRedo();
		assertEquals(test2.concat(test2),
				miniEditor.getBuffer());
	}
	/**
	 * Start Recording, stop recording then play
	 */
	@Test
	public void editorRecorderTest() {
		miniEditor.editorStartRecording();
		//change selections to be "generic" for replaying
		miniEditor.editorSelect(miniEditor.getBuffer().length(), miniEditor.getBuffer().length());
		miniEditor.editorInsert(test2);
		miniEditor.editorSelect(0, test2.length());
		miniEditor.editorCopy();
		miniEditor.editorSelect(miniEditor.getBuffer().length(), miniEditor.getBuffer().length());
		miniEditor.editorPaste();
		miniEditor.editorEndRecording();
		assertEquals(test2.concat(test2),
				miniEditor.getBuffer());
		//position at the end of bugger before replaying!
		miniEditor.editorSelect(miniEditor.getBuffer().length(), miniEditor.getBuffer().length());
		miniEditor.editorPlayRecording();
		assertEquals(test2.concat(test2).concat(test2).concat(test2),
				miniEditor.getBuffer());
		
	}
}
