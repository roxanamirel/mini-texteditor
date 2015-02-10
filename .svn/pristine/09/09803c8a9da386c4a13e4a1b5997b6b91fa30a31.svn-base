package fr.istic.aco.editor.core.command;

import java.util.List;

import fr.istic.aco.editor.core.RecorderEngine;

/**
 * The Class Replay.
 * @version 2
 */
public class Replay extends RecorderCommand {

	/** The history. */
	private List<Command> history;
	
	/**
	 * Instantiates a new replay.
	 *
	 * @param engine the engine
	 * @param history the history
	 */
	public Replay(RecorderEngine engine, List<Command> history) {
		super(engine);
		this.history = history;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.command.RecorderCommand#execute()
	 */
	@Override
	public void execute() {
		engine.replay(history);
	}

}