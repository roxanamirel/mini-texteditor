package fr.istic.aco.editor.core.command;

import fr.istic.aco.editor.core.RecorderEngine;

/**
 * The Class StopRecord.
 * @version 2
 */
public class StopRecord extends RecorderCommand {

	/** The stop index. */
	private int stopIndex;

	/**
	 * Instantiates a new stop record.
	 *
	 * @param engine the engine
	 * @param stopIndex the stop index
	 */
	public StopRecord(RecorderEngine engine, int stopIndex) {
		super(engine);
		this.stopIndex = stopIndex;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.command.RecorderCommand#execute()
	 */
	@Override
	public void execute() {
		engine.stopRecording(stopIndex);
	}

}
