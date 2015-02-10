package fr.istic.aco.editor.core;

/**
 * The Interface Selection.
 * @version 1
 */
public interface Selection {

	/**
	 * Gets the begin.
	 * 
	 * @return the begin index
	 */
	int getBegin();

	/**
	 * Gets the end.
	 * 
	 * @return the end index
	 */
	int getEnd();

	/**
	 * Sets the begin.
	 * 
	 * @param begin
	 *            the new begin
	 */
	void setBegin(int begin);

	/**
	 * Sets the end.
	 * 
	 * @param end
	 *            the new end
	 */
	void setEnd(int end);

	/**
	 * Gets the length.
	 * 
	 * @return the length
	 */
	int getLength();
}
