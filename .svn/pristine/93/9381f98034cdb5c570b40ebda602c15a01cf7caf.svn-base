package fr.istic.aco.editor.core.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.core.RecorderManager;
import fr.istic.aco.editor.core.impl.RecorderManagerImpl;

/**
 * The Class RecorderManagerTest.
 */
public class RecorderManagerTest {
	
	/** The recorder manager. */
	private RecorderManager recorderManager;
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		recorderManager = new RecorderManagerImpl();
	}

	/**
	 * Should not record.
	 */
	@Test
	public void shouldNotRecord() {
		assertEquals(false, recorderManager.isRecording());
	}
	
	/**
	 * Should record.
	 */
	@Test
	public void shouldRecord() {
		recorderManager.record(true);
		assertEquals(true, recorderManager.isRecording());
	}
	
	/**
	 * Should stop record.
	 */
	@Test
	public void shouldStopRecord() {
		recorderManager.record(false);
		assertEquals(false, recorderManager.isRecording());
	}

}
