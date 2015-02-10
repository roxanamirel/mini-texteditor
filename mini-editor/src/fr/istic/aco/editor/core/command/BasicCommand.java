package fr.istic.aco.editor.core.command;

import fr.istic.aco.editor.core.MiniEditorEngine;

/**
 * The Class BasicCommand.
 * @version 1
 */
 abstract class BasicCommand implements Command {
	
	/** The concrete engine. */
	protected MiniEditorEngine engine;
    
	/**
	 * Instantiates a new basic command.
	 *
	 * @param engine the engine
	 */
	 BasicCommand(MiniEditorEngine engine) {
		this.engine = engine;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.command.Command#execute()
	 */
	@Override
	public abstract void execute();

}
