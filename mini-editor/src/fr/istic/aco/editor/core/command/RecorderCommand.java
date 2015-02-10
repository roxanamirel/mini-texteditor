package fr.istic.aco.editor.core.command;

import fr.istic.aco.editor.core.RecorderEngine;

/**
 * The Class RecorderCommand.
 * @version 2
 */
public abstract class RecorderCommand implements Command {

	/** The engine. */
	protected RecorderEngine engine;

	/**
	 * Instantiates a new recorder command.
	 *
	 * @param engine the engine
	 */
	 RecorderCommand(RecorderEngine engine) {
		this.engine = engine;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.command.Command#execute()
	 */
	@Override
	public abstract void execute();
}
