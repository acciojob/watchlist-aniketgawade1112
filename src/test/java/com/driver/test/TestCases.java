package com.driver.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Objects;

import com.driver.Movie;
import com.driver.MovieController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.driver.Application;

@SpringBootTest(classes = Application.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestCases {

    @Autowired
    MovieController movieController;

    @Test
    public void testAddMovie() {
        Movie movie = new Movie("RRR", 120, 9.0);

        ResponseEntity<String> ans = movieController.addMovie(movie);
        ResponseEntity<Movie> movieResponse = movieController.getMovieByName("RRR");
        if (Objects.nonNull(movieResponse)) {
            assertEquals(9.0, movieResponse.getBody().getImdbRating());
        }

    }
}
