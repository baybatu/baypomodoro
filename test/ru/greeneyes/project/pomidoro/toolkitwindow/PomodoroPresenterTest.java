package ru.greeneyes.project.pomidoro.toolkitwindow;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class PomodoroPresenterTest {

	@Test
	public void shouldShowMinuteLabelAsMinInIMSoftware() {
		String result = PomodoroPresenter.remainingTimeInMinutes(121);
		assertThat(result, equalTo("2"));
	}
}
