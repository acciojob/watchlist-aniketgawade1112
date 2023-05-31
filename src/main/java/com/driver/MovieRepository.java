package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {

    HashMap<String, Movie> movieDb = new HashMap<>();

    HashMap<String, Director> directorDb = new HashMap<>();

    HashMap<String, String> movieDirectorPair = new HashMap<>();

    public String addMovie(Movie movie) {
        String key = movie.getName();
        movieDb.put(key, movie);
        return "Movie added successfully";
    }

    public String addDirector(Director director) {
        String key = director.getName();
        directorDb.put(key, director);
        return "Director added successfully";
    }

    public String addMovieDirectorPair(String movieName, String directorName) {
        movieDirectorPair.put(movieName, directorName);
        return "Connected them Successfully";
    }

    public Movie getMovieByName(String movieName) {
        if (movieDb.containsKey(movieName)) {
            return movieDb.get(movieName);
        }
        return null;
    }

    public Director getDirectorByName(String directorName) {
        if (directorDb.containsKey(directorName)) {
            return directorDb.get(directorName);
        }
        return null;
    }

    public String removeDirector(String directorName) {
        // directorDb amd also need to delete the entries in movieDb HashMap
        // iterate the complete HashMap
        directorDb.remove(directorName);

        for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
            if (entry.getValue().equals(directorName)) {
                String movieName = entry.getKey();
                movieDb.remove(movieName);
                movieDirectorPair.remove(movieName);
            }
        }
        return "Director removed successfully";
    }

    public String deleteAllDirectors() {
        for(String directorName : directorDb.keySet()) {
            directorDb.remove(directorName);
            for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
                if (entry.getValue().equals(directorName)) {
                    String movieName = entry.getKey();
                    movieDb.remove(movieName);
                    movieDirectorPair.remove(movieName);
                }
            }
        }
        return "Successfully deleted directors";
    }

    public List<Movie> getMoviesByDirectorName(String directorName) {

        List<Movie> movies = new ArrayList<>();

        for(Map.Entry<String, String> entry : movieDirectorPair.entrySet()) {
            if (entry.getValue().equals(directorName)) {
                String movieName = entry.getKey();
                Movie movie = movieDb.get(movieName);
                movies.add(movie);
            }
        }
        return movies;
    }

    public List<Movie> findAllMovies() {
        List<Movie> ans = new ArrayList<>();
//        return new ArrayList<>(movieDb.values());
        for(Map.Entry<String, Movie> entry : movieDb.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
