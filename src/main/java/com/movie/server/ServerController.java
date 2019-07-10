package com.movie.server;

import com.movie.server.models.Actor;
import com.movie.server.repositories.ActorRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class ServerController {

    @Autowired
    private ActorRepository actorRepository;

    @RequestMapping(value = "/allActors", method = RequestMethod.GET)
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @RequestMapping(value = "/Actor/{id}", method = RequestMethod.GET)
    public Actor getActorById(@PathVariable("id") ObjectId id) {
        return actorRepository.findBy_id(id);
    }

    @RequestMapping(value = "/addActor", method = RequestMethod.POST)
    public Actor createActor(@Valid @RequestBody Actor actor) {
        actor.set_id(ObjectId.get());
        actorRepository.save(actor);
        return actor;
    }
    @RequestMapping(value = "/Actor/{id}", method = RequestMethod.DELETE)
    public void deleteActor(@PathVariable ObjectId id) {
        actorRepository.delete(actorRepository.findBy_id(id));
    }

    @RequestMapping(value = "/Actor/{id}", method = RequestMethod.PUT)
    public void modifyActorById(@PathVariable("id") ObjectId id, @Valid @RequestBody Actor actor) {
        actor.set_id(id);
        actorRepository.save(actor);
    }

}
