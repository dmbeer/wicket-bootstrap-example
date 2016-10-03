/*
 * Copyright 2013 David Beer.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.DropDownButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.MenuBookmarkablePageLink;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.MenuDivider;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.dropdown.MenuHeader;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.GlyphIconType;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.*;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;
import de.agilecoders.wicket.core.settings.ITheme;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeIconType;
import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by dbeer on 12/12/13.
 */
public class HeaderPanel extends Panel {

    public HeaderPanel(String id) {
        super(id);

        add(navbar());
    }

    private Navbar navbar() {
        Navbar navbar = new Navbar("navbar");

        navbar.setPosition(Navbar.Position.TOP);
        navbar.setInverted(true);

        // show brand name
        navbar.setBrandName(Model.of("Wicket Bootstrap"));

//        navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.LEFT,
//                new NavbarButton<Void>(HomePage.class, Model.of("Overview")).setIconType(GlyphIconType.home)));
        navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.RIGHT,
                new NavbarButton<Void>(HomePage.class, Model.of("Overview")).setIconType(GlyphIconType.home)));

        DropDownButton dropdown = new NavbarDropDownButton(Model.of("Themes")) {
            @Override
            public boolean isActive(Component item) {
                return false;
            }

            @Override
            protected List<AbstractLink> newSubMenuButtons(final String buttonMarkupId) {
                final List<AbstractLink> subMenu = new ArrayList<>();
                subMenu.add(new MenuHeader(Model.of("all available themes:")));
                subMenu.add(new MenuDivider());

                final IBootstrapSettings settings = Bootstrap.getSettings(getApplication());
                final List<ITheme> themes = settings.getThemeProvider().available();

                for (final ITheme theme : themes) {
                    PageParameters params = new PageParameters();
                    params.set("theme", theme.name());

                }

                return subMenu;
            }
        }.setIconType(GlyphIconType.book);

        navbar.addComponents(new ImmutableNavbarComponent(dropdown, Navbar.ComponentPosition.RIGHT));

        return navbar;
    }
}
