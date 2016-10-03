package example;

import com.google.common.base.Charsets;
import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.BootstrapSettings;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.Before;

/**
 * Created by dbeer on 03/09/16.
 */
public class WicketAplicationTest {

    private WicketTester tester;
    private WebApplication application;

    protected final WicketTester tester() {
        return tester;
    }

    @Before
    public final void before() {
        application = newWebApplication();

        tester = new WicketTester(application);
    }

    @After
    public final void tearDown() throws Exception {
        if (tester != null) {
            tester.destroy();
        }
    }

    protected WebApplication newWebApplication() {
        return new WebApplication() {

            @Override
            protected void init() {
                super.init();

                Bootstrap.builder()
                        .withBootstrapSettings(WicketAplicationTest.this.createBootstrapSettings())
                        .install(this);

                getMarkupSettings().setStripWicketTags(false);
                getMarkupSettings().setDefaultMarkupEncoding(Charsets.UTF_8.name());

                WicketAplicationTest.this.init(this);
            }

            @Override
            public Class<? extends Page> getHomePage() {
                return WicketAplicationTest.this.getHomePage();
            }

        };
    }

    private IBootstrapSettings createBootstrapSettings() {
        return new BootstrapSettings();
    }

    protected Class<? extends Page> getHomePage() {
        return Page.class;
    }

    protected void init(WebApplication webApplication) {
    }

}
