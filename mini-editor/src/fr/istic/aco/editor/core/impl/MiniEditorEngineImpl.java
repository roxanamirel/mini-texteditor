package fr.istic.aco.editor.core.impl;

import fr.istic.aco.editor.core.Buffer;
import fr.istic.aco.editor.core.Clipboard;
import fr.istic.aco.editor.core.MiniEditorEngine;
import fr.istic.aco.editor.core.Selection;
import fr.istic.aco.editor.core.command.Cut;
import fr.istic.aco.editor.core.command.Insert;
import fr.istic.aco.editor.core.command.Paste;

/**
 * The Class MiniEditorEngineImpl.
 * Receiver class
 * @version 1
 */
public class MiniEditorEngineImpl implements MiniEditorEngine {

	/** The buffer. */
	private Buffer buffer;
	
	/** The selection. */
	private Selection selection;
	
	/** The clipboard. */
	private Clipboard clipboard;

	/**
	 * Instantiates a new mini editor engine impl.
	 */
	public MiniEditorEngineImpl() {
		this.buffer = new BufferImpl();
		this.selection = new SelectionImpl();
		this.clipboard = new ClipboardImpl();
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.MiniEditorEngine#getBuffer()
	 */
	@Override
	public Buffer getBuffer() {
		return buffer;

	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.MiniEditorEngine#getSelection()
	 */
	@Override
	public Selection getSelection() {
		return selection;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.MiniEditorEngine#getClipboard()
	 */
	@Override
	public Clipboard getClipboard() {
		return clipboard;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.MiniEditorEngine#engineSelect(int, int)
	 */
	@Override
	public void engineSelect(int start, int stop) {
		selection.setBegin(start);
		selection.setEnd(stop);
		String selected = buffer.read(selection.getBegin(), selection.getEnd()) != "" ? buffer
				.read(selection.getBegin(), selection.getEnd())
				: "You are at the end of buffer";
		System.out.println("DEBUG: selecting interval [" + selection.getBegin()
				+ "," + selection.getEnd() + "].  " + selected);

	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.MiniEditorEngine#enginePaste()
	 */
	@Override
	public void enginePaste() {
		buffer.write(selection.getBegin(), selection.getEnd(), clipboard.read());
		System.out.println("DEBUG: 	Paste ["
				+ buffer.read(0, buffer.getLength()) + "]");

	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.MiniEditorEngine#engineInsert(java.lang.String)
	 */
	@Override
	public void engineInsert(String insertString) {
		System.out.println("DEBUG: inserting text [" + insertString + "]");
		if (getSelection().getLength() != 0) {
			buffer.write(getSelection().getBegin(), getSelection().getEnd(),
					insertString);
		} else if (getSelection().getBegin() == 0
				&& getSelection().getEnd() == 0) {// at the beginning
			buffer.write(0, 0, insertString);
		} else if (getSelection().getBegin() > buffer.getLength()) {// at
																	// the
																	// end
			buffer.write(buffer.getLength(),
					buffer.getLength() + insertString.length(), insertString);

		}
		System.out.println("DEBUG: Text is: "
				+ buffer.read(0, buffer.getLength()));

	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.MiniEditorEngine#engineCut()
	 */
	@Override
	public void engineCut() {
		clipboard.write(buffer.read(selection.getBegin(), selection.getEnd()));
		buffer.write(selection.getBegin(), selection.getEnd(), "");
		System.out.println("DEBUG: Cut: Clipboard contains now "
				+ clipboard.read());

	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.MiniEditorEngine#engineCopy()
	 */
	@Override
	public void engineCopy() {
		clipboard.write(buffer.read(selection.getBegin(), selection.getEnd()));
		System.out.println("DEBUG: Copy: . Clipboard contains now "
				+ clipboard.read());

	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.UndoRedoOperation#engineUndo(fr.istic.aco.editor.core.command.Insert)
	 */
	@Override
	public void engineUndo(Insert insertCommand) {
		this.buffer = insertCommand.getBuffer();
		System.out.println("DEBUG: UNDO INSERT: . Buffer contains now "
				+ buffer.read(0, buffer.getLength()));
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.UndoRedoOperation#engineUndo(fr.istic.aco.editor.core.command.Cut)
	 */
	@Override
	public void engineUndo(Cut cutCommand) {
		this.buffer = cutCommand.getBuffer();
		System.out.println("DEBUG: UNDO CUT: . Buffer contains now "
				+ buffer.read(0, buffer.getLength()));

	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.UndoRedoOperation#engineUndo(fr.istic.aco.editor.core.command.Paste)
	 */
	@Override
	public void engineUndo(Paste pasteCommand) {
		this.buffer = pasteCommand.getBuffer();
		System.out.println("DEBUG: UNDO PASTE: . Buffer contains now "
				+ buffer.read(0, buffer.getLength()));

	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.UndoRedoOperation#engineRedo(fr.istic.aco.editor.core.command.Insert)
	 */
	@Override
	public void engineRedo(Insert insertCommand) {
		this.selection = insertCommand.getSelection();
		engineInsert(insertCommand.getInsertString());
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.UndoRedoOperation#engineRedo(fr.istic.aco.editor.core.command.Cut)
	 */
	@Override
	public void engineRedo(Cut cutCommand) {
		this.selection = cutCommand.getSelection();
		engineCut();
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.UndoRedoOperation#engineRedo(fr.istic.aco.editor.core.command.Paste)
	 */
	@Override
	public void engineRedo(Paste pasteCommand) {
		this.selection = pasteCommand.getSelection();
		enginePaste();
	}

}
