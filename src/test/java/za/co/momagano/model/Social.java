package za.co.momagano.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Social {
    private final String platform;
    private final String handle;

    public Social(String social) {
        final String[] strings = social.split(":");
        this.platform = strings[0].trim();
        this.handle = strings[1].trim();
    }

    static List<Social> getSocials(String socials) {
        return Arrays.stream(socials.split(","))
                .map(s-> new Social(s))
                .collect(Collectors.toList());
    }

    public String getPlatform() {
        return platform;
    }

    public String getHandle() {
        return handle;
    }
}
