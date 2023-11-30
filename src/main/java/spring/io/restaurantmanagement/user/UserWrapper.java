package spring.io.restaurantmanagement.user;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserWrapper {
    private List<User> users;

    public UserWrapper(Iterable<User> users) {
        this.users = new ArrayList<User>();
        Iterator<User> it = users.iterator();
        while (it.hasNext()) {
            this.users.add(it.next());
        }
    }
}
