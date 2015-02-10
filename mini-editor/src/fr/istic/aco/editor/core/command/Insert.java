package fr.istic.aco.editor.core.command;

import fr.istic.aco.editor.core.Buffer;
import fr.istic.aco.editor.core.MiniEditorEngine;
import fr.istic.aco.editor.core.Selection;
import fr.istic.aco.editor.core.impl.BufferImpl;
import fr.istic.aco.editor.core.impl.SelectionImpl;

/**
 * The Class Insert.
 * @version 1
 */
public class Insert extends BasicCommand implements UndoableRedoable {

	/** The insert string. */
	private String insertString;

	/** The buffer - used for undo */
	private Buffer buffer;

	/** The selection. */
	private Selection selection;

	/** The undone. */
	private boolean undone;

	/**
	 * Instantiates a new insert.
	 * 
	 * @param engine
	 *            the engine
	 * @param insertString
	 *            the insert string
	 */
	public Insert(MiniEditorEngine engine, String insertString) {
		super(engine);
		this.insertString = insertString;
		this.buffer = new BufferImpl(engine.getBuffer());
		this.selection = new SelectionImpl(engine.getSelection());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.aco.editor.core.command.BasicCommand#execute()
	 */
	@Override
	public void execute() {
		engine.engineInsert(insertString);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.aco.editor.core.command.UndoableRedoable#undo()
	 */
	@Override
	public void undo() {
		engine.engineUndo(this);
		undone = true;
	}

	/**
	 * Gets the buffer.
	 * 
	 * @return the buffer
	 */
	public Buffer getBuffer() {
		return buffer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.aco.editor.core.command.UndoableRedoable#isUndoed()
	 */
	@Override
	public boolean isUndone() {
		return undone;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.istic.aco.editor.core.command.UndoableRedoable#redo()
	 */
	@Override
	public void redo() {
		engine.engineRedo(this);
		undone = false;

	}

	/**
	 * Gets the insert string.
	 * 
	 * @return the insertString
	 */
	public String getInsertString() {
		return insertString;
	}

	/**
	 * Gets the selection.
	 * 
	 * @return the selection
	 */
	public Selection getSelection() {
		return this.selection;
	}

}
