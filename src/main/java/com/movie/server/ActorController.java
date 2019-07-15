package com.movie.server;

import com.movie.server.models.Actor;
import com.movie.server.models.Movie;
import com.movie.server.repositories.ActorRepository;
import com.movie.server.repositories.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class ActorController {

    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @RequestMapping(value = "/actors/get-all", method = RequestMethod.GET)
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @RequestMapping(value = "/actors/get/{id}", method = RequestMethod.GET)
    public Actor getActorById(@PathVariable("id") ObjectId id) {
        return actorRepository.findBy_id(id);
    }

    @RequestMapping(value = "/actors/add-actor", method = RequestMethod.POST)
    public Actor createActor(@Valid @RequestBody Actor actor) {
        actor.set_id(ObjectId.get());
        actorRepository.save(actor);
        return actor;
    }
    @RequestMapping(value = "/actors/delete/{id}", method = RequestMethod.DELETE)
    public void deleteActor(@PathVariable ObjectId id) {
        actorRepository.delete(actorRepository.findBy_id(id));
    }

    @RequestMapping(value = "/actors/modify/{id}", method = RequestMethod.PUT)
    public void modifyActorById(@PathVariable("id") ObjectId id, @Valid @RequestBody Actor actor) {
        actor.set_id(id);
        actorRepository.save(actor);
    }




}
