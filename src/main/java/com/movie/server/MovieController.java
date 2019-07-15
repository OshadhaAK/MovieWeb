package com.movie.server;

import com.movie.server.models.Actor;
import com.movie.server.models.Movie;
import com.movie.server.models.MovieData;
import com.movie.server.repositories.ActorRepository;
import com.movie.server.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class MovieController {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    @RequestMapping(value = "/movies/get-all", method = RequestMethod.GET)
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }


    @RequestMapping(value = "/movies/get/{id}", method = RequestMethod.GET)
    public MovieData getMovieById(@PathVariable("id") ObjectId id) {

        Movie movie = movieRepository.findBy_id(id);

        MovieData movieData = new MovieData();

        movieData.set_id(movie.get_id());
        movieData.setName(movie.getName());
        movieData.setYear(movie.getYear());
        movieData.setGenre(movie.getGenre());
        movieData.setDescription(movie.getDescription());
        movieData.setLink(movie.getLink());

        List<Actor> actorList = new ArrayList<>();

        for (String actorId:movie.getActorIds()){
            ObjectId a = new ObjectId(actorId);
            Actor actor = actorRepository.findBy_id(a);
            actorList.add(actor);
        }

        movieData.setActors(actorList);

        return movieData;
    }

    @RequestMapping(value = "/movies/add-movie", method = RequestMethod.POST)
    public @Valid Movie createMovie(@Valid @RequestBody Movie movie) {
        movie.set_id(ObjectId.get());
        movieRepository.save(movie);
        return movie;
    }
    @RequestMapping(value = "/movies/delete/{id}", method = RequestMethod.DELETE)
    public void deleteMovie(@PathVariable ObjectId id) {
        movieRepository.delete(movieRepository.findBy_id(id));
    }

    @RequestMapping(value = "/movies/modify/{id}", method = RequestMethod.PUT)
    public void modifyMovieById(@PathVariable("id") ObjectId id, @Valid @RequestBody Movie movie) {
        movie.set_id(id);
        movieRepository.save(movie);
    }




}
