package fr.istic.aco.editor.core.command;

import fr.istic.aco.editor.core.RecorderEngine;

/**
 * The Class StartRecord.
 * @version 2
 */
public class StartRecord extends RecorderCommand {
	
	/** The start index. */
	private int startIndex;

	/**
	 * Instantiates a new start record.
	 *
	 * @param engine the engine
	 * @param startIndex the start index
	 */
	public StartRecord(RecorderEngine engine, int startIndex) {
		super(engine);
		this.startIndex = startIndex;
	}

	/* (non-Javadoc)
	 * @see fr.istic.aco.editor.core.command.RecorderCommand#execute()
	 */
	@Override
	public void execute() {
		engine.startRecording(startIndex);		
	}

}
