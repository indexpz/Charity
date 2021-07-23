package pl.indexpz.charity.web.converters;

import lombok.Data;
import org.springframework.stereotype.Component;
import pl.indexpz.charity.domain.model.User;

import javax.persistence.Converter;


@Component
public class UserConverter {

    public User toUser(String username, String password){
        return new User(null, username, password, null, null);
    }
}
