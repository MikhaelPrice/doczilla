package doczila.task2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Students {
    private int id;
    private String name;
    private String surname;
    private String lastname;
    private Date birthday;
    private int groupNumber;
}
