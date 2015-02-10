package fr.istic.aco.editor.core;

/**
 * The Interface RecorderManager.
 * @version 2
 */
public interface RecorderManager {

	/**
	 * Checks if is recording.
	 * 
	 * @return true, if is recording
	 */
	public abstract boolean isRecording();

	/**
	 * Record.
	 * 
	 * @param isRecording
	 *            the is recording
	 */
	public abstract void record(boolean isRecording);

}
