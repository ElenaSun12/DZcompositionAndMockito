// MovieManagerTest.java

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MovieManagerTest {

    @Test
    public void testfindAll() {
        MovieManager manager = new MovieManager();

        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");

        String[] actual = manager.findAll();
        String[] expected = {"Film I", "Film II", "Film III"};
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindLast() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");

        String[] actual = manager.findLast();
        String[] expected = {"Film III", "Film II", "Film I"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastDefaultLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        manager.addMovie("Film IV");
        manager.addMovie("Film V");
        manager.addMovie("Film VI");

        String[] actual = manager.findLast();
        String[] expected = {"Film VI", "Film V", "Film IV", "Film III", "Film II"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastCustomLimit() {
        MovieManager manager = new MovieManager(3);
        manager.addMovie("Film I");
        manager.addMovie("Film II");
        manager.addMovie("Film III");
        manager.addMovie("Film IV");

        String[] actual = manager.findLast();
        String[] expected = {"Film IV", "Film III", "Film II"};


        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWhenMoviesLessThanLimit() {
        MovieManager manager = new MovieManager();
        manager.addMovie("Film I");

        String[] actual = manager.findLast();
        String[] expected = {"Film I"};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastWhenNoMovies() {
        MovieManager manager = new MovieManager();

        String[] expected = {};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}