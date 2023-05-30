package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie) {
        String ans = movieService.addMovie(movie);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director) {
        String ans = movieService.addDirector(director);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movieName") String movieName,
                                                       @RequestParam("directorName") String directorName) {
        String ans = movieService.addMovieDirectorPair(movieName, directorName);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable Movie movie) {
        Movie movie1 = movieService.getMovieByName(movie);
        if (Objects.nonNull(movie1)) {
            return new ResponseEntity<>(movie, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable Director director) {
        Director director1 = movieService.getDirectorByName(director);
        if (Objects.nonNull(director1)) {
            return new ResponseEntity<>(director, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<Movie>> getMoviesByDirectorName(String directorName) {
        List<Movie> ans = movieService.getMoviesByDirectorName(directorName);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<Movie>> findAllMovies() {
        List<Movie> ans = movieService.findAllMovies();
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam ("directorName") String directorName) {
        String ans = movieService.deleteDirectorByName(directorName);
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors() {
        String ans = movieService.deleteAllDirectors();
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }
}
