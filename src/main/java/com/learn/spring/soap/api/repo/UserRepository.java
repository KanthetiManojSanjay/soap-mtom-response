package com.learn.spring.soap.api.repo;

import com.learn.spring.soap.api.users.ProfilePicture;
import com.learn.spring.soap.api.users.User;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kansanja on 12/02/23.
 */
@Component
public class UserRepository {

    private static final String PROFILE_PICTURE_PATH = "/Users/kansanja/Downloads/soap-mtom-response/src/main/resources/";
    private static final Map<Integer, User> USER_MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        User user = new User();
        user.setId(1);
        user.setFirstname("Nature");
        user.setLastname("Landscape");
        ProfilePicture profilePicture = new ProfilePicture();
        try {
            profilePicture.setName(user.getId() + "_" + user.getFirstname() + ".jpeg");
            profilePicture.setContent(ImageIO.read(new File(PROFILE_PICTURE_PATH + user.getId() + ".jpeg")));
            user.setProfilePicture(profilePicture);
        } catch (Exception e) {
            e.getStackTrace();
        }
        USER_MAP.put(user.getId(), user);

    }


    public User getUserById(int userId) {
        return USER_MAP.get(userId);
    }
}
