package fr.istic.aco.editor.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import fr.istic.aco.editor.core.command.Command;

/**
 * The Class MiniEditorCommandInvoker. the invoker class
 * @version 1
 */
public class MiniEditorCommandInvoker {

	/** The history. */
	private List<Command> history;

	/**
	 * Instantiates a new mini editor command invoker.
	 */
	public MiniEditorCommandInvoker() {
		history = new ArrayList<>();
	}

	/**
	 * Gets the history.
	 * 
	 * @return the history
	 */
	public List<Command> getHistory() {
		return history;
	}

	/**
	 * Store and execute.
	 * 
	 * @param command
	 *            the command
	 */
	public void storeAndExecute(Command command) {
		history.add(command);
		command.execute();
	}

	/**
	 * Gets the reversed history.
	 * 
	 * @return the reversed history
	 */
	public List<Command> getReversedHistory() {
		List<Command> reversedHistory = new ArrayList<Command>(history);
		Collections.reverse(reversedHistory);
		return reversedHistory;
	}
}
