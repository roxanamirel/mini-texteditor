package fr.istic.aco.editor.core;

import fr.istic.aco.editor.core.command.Cut;
import fr.istic.aco.editor.core.command.Insert;
import fr.istic.aco.editor.core.command.Paste;

/**
 * The Interface UndoRedoOperation.
 * @version 3
 */
public interface UndoRedoEngineOperation {
	
	/**
	 * Engine undo.
	 *
	 * @param insertCommand the insert command
	 */
	void engineUndo(Insert insertCommand);

	/**
	 * Engine undo.
	 *
	 * @param cutCommand the cut command
	 */
	void engineUndo(Cut cutCommand);

	/**
	 * Engine undo.
	 *
	 * @param pasteCommand the paste command
	 */
	void engineUndo(Paste pasteCommand);
	
	/**
	 * Engine redo.
	 *
	 * @param insertCommand the insert command
	 */
	void engineRedo(Insert insertCommand);

	/**
	 * Engine redo.
	 *
	 * @param cutCommand the cut command
	 */
	void engineRedo(Cut cutCommand);

	/**
	 * Engine redo.
	 *
	 * @param pasteCommand the paste command
	 */
	void engineRedo(Paste pasteCommand);

}
