package fr.istic.aco.editor.core;

import java.util.List;

import fr.istic.aco.editor.core.command.Command;

/**
 * The Interface RecorderEngine.
 * @version 2
 */
public interface RecorderEngine extends MiniEditorReceiver {

	/**
	 * Start recording.
	 *
	 * @param start the starting index
	 */
	public abstract void startRecording(int start);

	/**
	 * Stop recording.
	 *
	 * @param finalIndex the final index
	 */
	public abstract void stopRecording(int finalIndex);

	/**
	 * Replay.
	 *
	 * @param history the history
	 */
	public abstract void replay(List<Command> history);

}
