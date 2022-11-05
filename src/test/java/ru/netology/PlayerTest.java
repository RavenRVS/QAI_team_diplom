package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    // другие ваши тесты

    @Test
    public void shouldSumGenreALotOfGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Змейка", "Аркады");


        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);

        player.play(game, 3);
        player.play(game1, 3);


        int expected = 6;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }


    @Test
    public void PlayPlayerIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);

        int expected = 6;

        int actual = player.play(game, 6);
        assertEquals(expected, actual);
    }

    @Test
    public void PlayPlayerIfPlayGameRepeatedly() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 6);
        player.play(game, 4);
        int expected = 10;

        int actual = player.play(game, 0);
        assertEquals(expected, actual);
    }


    @Test
    public void shouldMostPlayerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Змейка", "Аркады");
        Game game2 = store.publishGame("Ведьмак", "RPG");

        Player player = new Player("Petya");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);

        player.play(game, 3);
        player.play(game1, 5);
        player.play(game2, 4);

        Game expected = game1;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);

    }
}
