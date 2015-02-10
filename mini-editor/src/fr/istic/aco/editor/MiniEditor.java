package fr.istic.aco.editor;

/**
 * The Interface MiniEditor.
 * 
 */
public interface MiniEditor {

	/**
	 * Gets the buffer.
	 * 
	 * @version 1
	 * @return the buffer
	 */
	public String getBuffer();

	/**
	 * Gets the selection.
	 * 
	 * @version 1
	 * @return the selection
	 */
	public String getSelection();

	/**
	 * Gets the clipboard.
	 * 
	 * @version 1
	 * @return the clipboard
	 */
	public String getClipboard();

	/**
	 * Editor insert.
	 * 
	 * @version 1
	 * @param text
	 *            the string to be inserted
	 */
	public void editorInsert(String text);

	/**
	 * Editor select.
	 * 
	 * @version 1
	 * @param start
	 *            the starting index
	 * @param stop
	 *            the stopping index
	 */
	public void editorSelect(int start, int stop);

	/**
	 * Editor copy.
	 * 
	 * @version 1
	 */
	public void editorCopy();

	/**
	 * Editor cut.
	 * 
	 * @version 1
	 */
	public void editorCut();

	/**
	 * Editor paste.
	 * 
	 * @version 1
	 */
	public void editorPaste();

	/**
	 * Editor start recording.
	 * 
	 * @version 2
	 */
	public void editorStartRecording();

	/**
	 * Editor end recording.
	 * 
	 * @version 2
	 */
	public void editorEndRecording();

	/**
	 * Editor play recording.
	 * 
	 * @version 2
	 */
	public void editorPlayRecording();

	/**
	 * Editor redo.
	 * 
	 * @version 3
	 */
	public void editorRedo();

	/**
	 * Editor undo.
	 * 
	 * @version 3
	 */
	public void editorUndo();
}
