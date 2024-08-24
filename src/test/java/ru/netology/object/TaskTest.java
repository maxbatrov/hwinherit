package ru.netology.object;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void simpleTaskMatchesFound () {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);

    }

    @Test
    public void simpleTaskMatchesNotFound () {

        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");

        Assertions.assertFalse(actual);

    }

    @Test
    public void epicTaskMatchesFound () {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);


        boolean actual = epic.matches("Яйца");

        Assertions.assertTrue(actual);

    }

    @Test
    public void epicTaskMatchesNotFound () {

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);


        boolean actual = epic.matches("Квас");

        Assertions.assertFalse(actual);

    }

    @Test
    public void meetingTaskMatchesFoundTopic () {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean actual = meeting.matches("версии");

        Assertions.assertTrue(actual);

    }

    @Test
    public void meetingTaskMatchesFoundProject () {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertTrue(actual);

    }

    @Test
    public void meetingTaskMatchesNotFound () {

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );


        boolean actual = meeting.matches("обеда");

        Assertions.assertFalse(actual);

    }


}