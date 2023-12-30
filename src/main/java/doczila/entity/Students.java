package doczila.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Students {
    private int id;
    private String name;
    private String surname;
    private String lastname;
    private String birthday;
    private String group;
}
