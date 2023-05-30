package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String addMovie(Movie movie) {
        String ans = movieRepository.addMovie(movie);
        return ans;
    }

    public String addDirector(Director director) {
        String ans = movieRepository.addDirector(director);
        return ans;
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        return movieRepository.addMovieDirectorPair(movieName, directorName);
    }

    public Movie getMovieByName(Movie movie) {
        return movieRepository.getMovieByName(movie);
    }

    public Director getDirectorByName(Director director) {
        return movieRepository.getDirectorByName(director);
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
