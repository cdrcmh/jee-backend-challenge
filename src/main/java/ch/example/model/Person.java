package ch.example.model;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

import lombok.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"name", "gender", "age"})
@XmlRootElement(name = "person")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String gender;
    @XmlElement(required = true)
    protected BigInteger age;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Person)) {
            return false;
        }
        Person p = (Person) o;
        return name.equals(p.name)
                && gender.equals(p.gender)
                && age.equals(p.age);
    }

}
