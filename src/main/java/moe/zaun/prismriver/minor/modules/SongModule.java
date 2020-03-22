package moe.zaun.prismriver.minor.modules;

import com.google.inject.AbstractModule;
import moe.zaun.prismriver.minor.controller.SongController;
import moe.zaun.prismriver.minor.service.interfaces.SongService;
import moe.zaun.prismriver.minor.service.aws.AwsSongService;
import moe.zaun.prismriver.minor.service.aws.AwsModule;

public class SongModule extends AbstractModule {
    protected void configure() {
        this.bind(SongController.class);
        this.bind(SongService.class).to(AwsSongService.class);
        this.install(new AwsModule());
    }
}
