package ru.greeneyes.project.pomidoro.statuschanger;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CommandGeneratorTest {

	@Test
	public void shouldGenerateGoAwayCommandWithoutMessageForAdium() {
		CommandGenerator generator = new CommandGenerator();

		String command = generator.generateGoAwayCommand(IMSoftware.ADIUM);

		assertThat(command, equalTo("tell application \"Adium\" to go away"));
	}

	@Test
	public void shouldGenerateGoAwayCommandWithMessageForAdium() {
		CommandGenerator generator = new CommandGenerator();

		String command = generator.generateGoAwayCommand(IMSoftware.ADIUM, "Im out");

		assertThat(command, equalTo("tell application \"Adium\" to go away with message \"Im out\""));
	}

	@Test
	public void shouldGenerateGoAwayCommandWithoutMessageForiChat() {
		CommandGenerator generator = new CommandGenerator();

		String command = generator.generateGoAwayCommand(IMSoftware.MESSAGES);

		assertThat(command, equalTo("tell application \"Messages\" \nset status to away\nend tell"));
	}

	@Test
	public void shouldGenerateGoAwayCommandWithMessageForiChat() {
		CommandGenerator generator = new CommandGenerator();

		String command = generator.generateGoAwayCommand(IMSoftware.MESSAGES, "Im out");

		assertThat(command, equalTo("tell application \"Messages\" \nset status to away\nset status message to \"Im out\"\nend tell"));
	}

	@Test
	public void shouldGenerateAvailableCommandWithoutMessageForAdium() {
		CommandGenerator generator = new CommandGenerator();

		String command = generator.generateAvailableCommand(IMSoftware.ADIUM);

		assertThat(command, equalTo("tell application \"Adium\" to go available"));
	}

	@Test
	public void shouldGenerateAvailableCommandWithMessageForAdium() {
		CommandGenerator generator = new CommandGenerator();

		String command = generator.generateAvailableCommand(IMSoftware.ADIUM, "Im here");

		assertThat(command, equalTo("tell application \"Adium\" to go available with message \"Im here\""));
	}

	@Test
	public void shouldGenerateAvailableCommandWithoutMessageForMessages() {
		CommandGenerator generator = new CommandGenerator();

		String command = generator.generateAvailableCommand(IMSoftware.MESSAGES);

		assertThat(command, equalTo("tell application \"Messages\" \nset status to available\nend tell"));
	}

	@Test
	public void shouldGenerateAvailableCommandWithMessageForMessages() {
		CommandGenerator generator = new CommandGenerator();

		String command = generator.generateAvailableCommand(IMSoftware.MESSAGES, "Im here");

		assertThat(command, equalTo("tell application \"Messages\" \nset status to available\nset status message to \"Im here\"\nend tell"));
	}

}
