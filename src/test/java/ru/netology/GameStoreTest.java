package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.util.HashMap;
import java.util.Map;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldAddTwoGames() {

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("Марио Онлайн", "Аркады");

        assertTrue(store.containsGame(game1));
        assertTrue(store.containsGame(game2));
    }

    @Test
    public void shouldContainsGames() {

        GameStore store1 = new GameStore();
        GameStore store2 = new GameStore();
        Game game1 = store1.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store2.publishGame("Марио Онлайн", "Аркады");

        assertTrue(store1.containsGame(game1));
        assertFalse(store1.containsGame(game2));
        assertTrue(store2.containsGame(game2));
        assertFalse(store2.containsGame(game1));
    }

    @Test
    public void addPlayTime() {

        GameStore store = new GameStore();
        store.addPlayTime("Сергей", 8);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Сергей", 8);


        assertTrue(expected.equals(store.getPlayedTime()));

    }

    @Test
    public void addPlayTimeWithSumHours() {

        GameStore store = new GameStore();
        store.addPlayTime("Сергей", 8);
        store.addPlayTime("Сергей", 4);
        store.addPlayTime("Сергей", 4);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Сергей", 16);

        Assertions.assertTrue(expected.equals(store.getPlayedTime()));

    }

    @Test
    public void addPlayTimeWithTwoPlayers() {

        GameStore store = new GameStore();
        store.addPlayTime("Сергей", 8);
        store.addPlayTime("Сергей", 8);
        store.addPlayTime("Дмитрий", 4);
        store.addPlayTime("Дмитрий", 6);

        Map<String, Integer> expected = new HashMap<>();
        expected.put("Сергей", 16);
        expected.put("Дмитрий", 10);

        Assertions.assertTrue(expected.equals(store.getPlayedTime()));

    }

    @Test
    public void getMostPlayer() {
        GameStore store = new GameStore();
        store.addPlayTime("Сергей", 6);
        store.addPlayTime("Дмитрий", 8);
        store.addPlayTime("Василий", 7);

        String expected = "Дмитрий";
        String actual = store.getMostPlayer();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getMostPlayerWithoutPlayers() {
        GameStore store = new GameStore();

        String actual = store.getMostPlayer();

        Assertions.assertEquals(null, actual);
    }

    @Test
    public void getSumPlayedTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Сергей", 6);
        store.addPlayTime("Дмитрий", 8);
        store.addPlayTime("Василий", 7);

        int expected = 21;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);

    }

}