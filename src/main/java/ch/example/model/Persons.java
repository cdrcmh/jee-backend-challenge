package ch.example.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"person"})
@XmlRootElement(name = "persons")
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
