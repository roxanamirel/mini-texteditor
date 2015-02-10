package fr.istic.aco.editor.core.command.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import fr.istic.aco.editor.core.RecorderEngine;
import fr.istic.aco.editor.core.command.RecorderCommand;
import fr.istic.aco.editor.core.command.StartRecord;

/**
 * The Class StartRecordTest.
 */
public class StartRecordTest {

	/** The start record. */
	private RecorderCommand startRecord;
	
	/** The mocked recorder engine. */
	private RecorderEngine mockedRecorderEngine;
	
	/** The rn. */
	private Random rn;
	
	/** The Constant MAX. */
	private static final int MAX = 20;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		mockedRecorderEngine = mock(RecorderEngine.class);
		rn = new Random();
	}

	/**
	 * Test execute.
	 */
	@Test
	public void testExecute() {

		for (int counter = 0; counter < 3; counter++) {
			int startIndex = rn.nextInt(MAX);
			startRecord = new StartRecord(mockedRecorderEngine, startIndex);
			startRecord.execute();
			verify(mockedRecorderEngine).startRecording(startIndex);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
