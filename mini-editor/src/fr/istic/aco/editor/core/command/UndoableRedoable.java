package fr.istic.aco.editor.core.command;

/**
 * The Interface UndoableRedoable.
 * @version 3
 */
public interface UndoableRedoable {

	/**
	 * Undo.
	 */
	void undo();

	/**
	 * Redo.
	 */
	void redo();

	/**
	 * Checks if is undone.
	 *
	 * @return true, if is undone
	 */
	boolean isUndone();

}
