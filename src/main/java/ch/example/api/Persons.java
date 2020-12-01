package ch.example.api;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "person"
})
@XmlRootElement(name = "persons")
@Getter
@NoArgsConstructor
public class Persons {

    @XmlElement(required = true)
    protected List<Person> person;

    public List<Person> getPerson() {
        if (person == null) {
            person = new ArrayList<>();
        }
        return this.person;
    }

}
