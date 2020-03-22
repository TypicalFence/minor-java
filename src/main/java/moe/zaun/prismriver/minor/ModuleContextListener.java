package moe.zaun.prismriver.minor;

import com.google.common.collect.Lists;
import com.google.inject.Module;
import moe.zaun.prismriver.minor.modules.HelloModule;
import moe.zaun.prismriver.minor.modules.MainModule;
import moe.zaun.prismriver.minor.modules.OrderModule;
import moe.zaun.prismriver.minor.modules.SongModule;
import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import javax.servlet.ServletContext;
import java.util.List;

public class ModuleContextListener extends GuiceResteasyBootstrapServletContextListener {
    @Override
    protected List<? extends Module> getModules(ServletContext context) {
        return Lists.newArrayList(
                new MainModule(),
                new HelloModule(),
                new OrderModule(),
                new SongModule()
        );
    }
}
