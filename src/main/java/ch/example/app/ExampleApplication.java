package ch.example.app;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

import ch.example.controller.PersonController;

@ApplicationPath("/")
public class ExampleApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> h = new HashSet<>();
        h.add(PersonController.class);
        return h;
    }

}
