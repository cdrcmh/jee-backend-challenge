package ch.example.model;

import lombok.Builder;

@Builder
public class Event {
    boolean isValid;
    String message;
}
