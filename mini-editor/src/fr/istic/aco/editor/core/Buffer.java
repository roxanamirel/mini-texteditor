package fr.istic.aco.editor.core;

/**
 * The Interface Buffer.
 * @version 1
 */
public interface Buffer {

	/**
	 * Reads the string from the buffer.
	 * 
	 * @param begin
	 *            the begin index
	 * @param end
	 *            the end index
	 * @pre begin<end
	 * @return the string
	 * 
	 */
	String read(int begin, int end);

	/**
	 * Writes the string in the buffer.
	 * 
	 * @param begin
	 *            the begin index
	 * @param end
	 *            the end index
	 * @param text
	 *            the text to write
	 */
	void write(int begin, int end, String text);

	/**
	 * Gets the length.
	 * 
	 * @return the length of the buffer
	 */
	int getLength();

}
