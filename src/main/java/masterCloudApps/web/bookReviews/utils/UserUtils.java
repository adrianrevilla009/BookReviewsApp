package masterCloudApps.web.bookReviews.utils;

import masterCloudApps.web.bookReviews.models.User;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class UserUtils {
    public User convertFromStringToUser(String usr) {
        List<String> splitedUser = Arrays.stream(usr.split(" ")).toList();
        User user = new User(" ", " ");
        if (splitedUser.size() == 1) {
            user.setName(splitedUser.get(0));
        }
        if (splitedUser.size() == 2) {
            user.setName(splitedUser.get(0));
            user.setSurname(splitedUser.get(1));
        }
        if (splitedUser.size() > 2) {
            user.setName(splitedUser.get(0));
            String surname = "";
            for (int i = 1; i < splitedUser.size(); i++) {
                surname = surname + splitedUser.get(i) + " ";
            }
            user.setSurname(surname);
        }
        return user;
    }
}
