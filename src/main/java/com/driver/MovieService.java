package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    MovieRepository movieRepository = new MovieRepository();

    public String addMovie(Movie movie) {
        return movieRepository.addMovie(movie);
    }

    public String addDirector(Director director) {
        return movieRepository.addDirector(director);
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        return movieRepository.addMovieDirectorPair(movieName, directorName);
    }

    public Movie getMovieByName(String movieName) {
        return movieRepository.getMovieByName(movieName);
    }

    public Director getDirectorByName(String directorName) {
        return movieRepository.getDirectorByName(directorName);
    }

    public String deleteDirectorByName(String directorName) {
        return movieRepository.removeDirector(directorName);
    }

    public List<Movie> getMoviesByDirectorName(String directorName) {
        return movieRepository.getMoviesByDirectorName(directorName);
    }

    public List<Movie> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public String deleteAllDirectors() {
        return movieRepository.deleteAllDirectors();
    }
}
