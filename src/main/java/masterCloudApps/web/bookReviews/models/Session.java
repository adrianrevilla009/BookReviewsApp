package masterCloudApps.web.bookReviews.models;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Data
@SessionScope
@Component
public class Session {
    private User user;

    public Session() {
        this.user = new User();
    }

    public String getUserToString() {
        String usr = "";
        if (user.getName() != null) {
            usr += user.getName();
        }
        if (user.getSurname() != null) {
            usr += " " + user.getSurname();
        }
        return usr;
    }

    public void setUserName(String name) {
        this.user.setName(name);
    }

    public void setUserSurname(String surname) {
        this.user.setSurname(surname);
    }
}
