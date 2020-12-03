package ch.example.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Statistics {

    List<Event> events;

    @Override
    public String toString() {
        int total = events.size();
        long valid = events.stream().filter(e -> e.isValid).count();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("*** ExampleApplication Statistics ***" + "\n");
        stringBuilder.append("Total requests: ").append(total).append(" (valid: ").append(valid).append(" /").append(" invalid: ").append(total - valid).append(")\n");
        stringBuilder.append("Total added persons: \n"); //todo
        stringBuilder.append("Errors: \n");
        for (Event event : events) {
            if (!event.isValid) {
                stringBuilder.append(" [ERROR] ").append(event.message).append("\n");
            }
        }
        return stringBuilder.toString();
    }

}
