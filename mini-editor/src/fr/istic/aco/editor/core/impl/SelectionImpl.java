package fr.istic.aco.editor.core.impl;

import fr.istic.aco.editor.core.Selection;

/**
 * The Class SelectionImpl.
 * @version 1
 */
public class SelectionImpl implements Selection {
	
	/** The begin. */
	private int begin;
	
	/** The end. */
	private int end;

	/**
	 * Instantiates a new selection impl.
	 *
	 * @param selection the selection
	 */
	public SelectionImpl(Selection selection) {
		this.begin = selection.getBegin();
		this.end = selection.getEnd();
	}

	/**
	 * Instantiates a new selection impl.
	 */
	public SelectionImpl() {
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.Selection#getBegin()
	 */
	@Override
	public int getBegin() {
		return begin;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.Selection#getEnd()
	 */
	@Override
	public int getEnd() {
		return end;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.Selection#setBegin(int)
	 */
	@Override
	public void setBegin(int begin) {
		this.begin = begin;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.Selection#setEnd(int)
	 */
	@Override
	public void setEnd(int end) {
		this.end = end;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.Selection#getLength()
	 */
	@Override
	public int getLength() {
		return Math.abs(end - begin);
	}

}
