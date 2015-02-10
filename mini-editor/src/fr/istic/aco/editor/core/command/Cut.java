package fr.istic.aco.editor.core.command;

import fr.istic.aco.editor.core.Buffer;
import fr.istic.aco.editor.core.MiniEditorEngine;
import fr.istic.aco.editor.core.Selection;
import fr.istic.aco.editor.core.impl.BufferImpl;
import fr.istic.aco.editor.core.impl.SelectionImpl;

/**
 * The Class Cut.
 * @version 1
 */
public class Cut extends BasicCommand implements UndoableRedoable {

	/** The undone. */
	private boolean undone;
	
	/** The buffer. */
	private Buffer buffer;
	
	/** The selection. */
	private Selection selection;

	/**
	 * Instantiates a new cut.
	 *
	 * @param engine the engine
	 */
	public Cut(MiniEditorEngine engine) {
		super(engine);
		this.buffer = new BufferImpl(engine.getBuffer());
		this.selection = new SelectionImpl(engine.getSelection());
	}

	/**
	 * Gets the buffer.
	 *
	 * @return the buffer
	 */
	public Buffer getBuffer() {
		return buffer;
	}

	/**
	 * Gets the selection.
	 *
	 * @return the selection
	 */
	public Selection getSelection() {
		return this.selection;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.command.BasicCommand#execute()
	 */
	@Override
	public void execute() {
		engine.engineCut();
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.command.UndoableRedoable#undo()
	 */
	@Override
	public void undo() {
		engine.engineUndo(this);
		undone = true;

	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.command.UndoableRedoable#isUndoed()
	 */
	@Override
	public boolean isUndone() {
		return undone;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.command.UndoableRedoable#redo()
	 */
	@Override
	public void redo() {
		engine.engineRedo(this);
		undone = false;
	}

}
