package ch.example.api;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "gender",
        "age"
})
@XmlRootElement(name = "person")
@Getter
@Setter
@NoArgsConstructor
public class Person {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String gender;
    @XmlElement(required = true)
    protected BigInteger age;

}
