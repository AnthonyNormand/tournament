package fr.webant.tournament.user.model;

import java.io.Serializable;
import lombok.Data;

@Data
public class User implements Serializable {

    private String firstName;
    private String lastName;

    private String email;
    private String password;

}
