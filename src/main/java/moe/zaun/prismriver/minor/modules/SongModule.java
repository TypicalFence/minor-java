package moe.zaun.prismriver.minor.modules;

import com.google.inject.AbstractModule;
import moe.zaun.prismriver.minor.controller.SongController;
import moe.zaun.prismriver.minor.service.aws.AwsModule;
import moe.zaun.prismriver.minor.service.aws.AwsSongService;
import moe.zaun.prismriver.minor.service.interfaces.SongService;
import moe.zaun.prismriver.minor.service.mongodb.MongoModule;
import moe.zaun.prismriver.minor.service.mongodb.MongoSongService;

public class SongModule extends AbstractModule {

    private String type = "mongodb";

    protected void configure() {
        this.bind(SongController.class);

        if (this.type.equals("aws")) {
            this.bind(SongService.class).to(AwsSongService.class);
            this.install(new AwsModule());
        } else if (this.type.equals("mongodb")) {
            this.bind(SongService.class).to(MongoSongService.class);
            this.install(new MongoModule());
        }
    }
}
