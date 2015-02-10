package fr.istic.aco.editor.core.command;

import fr.istic.aco.editor.core.MiniEditorEngine;

/**
 * The Class Select.
 * @version 1
 */
public class Select extends BasicCommand {
	
	/** The start. */
	private int start;
	
	/** The stop. */
	private int stop;

	/**
	 * Instantiates a new select.
	 *
	 * @param engine the engine
	 * @param start the start
	 * @param stop the stop
	 */
	public Select(MiniEditorEngine engine,int start,int stop) {
		super(engine);
		this.start = start;
		this.stop = stop;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.command.BasicCommand#execute()
	 */
	@Override
	public void execute() {
		engine.engineSelect(start, stop);		
	}
}
