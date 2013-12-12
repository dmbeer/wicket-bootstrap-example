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

import de.agilecoders.wicket.core.markup.html.bootstrap.image.GlyphIconType;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarComponents;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

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
        navbar.setInverted(true);
        navbar.setPosition(Navbar.Position.TOP);
        navbar.brandName(Model.of("Wicket-Bootstrap3 Sample"));

        navbar.addComponents(NavbarComponents.transform(Navbar.ComponentPosition.RIGHT, new NavbarButton<HomePage>(HomePage.class, Model.of("Home"))
                .setIconType(GlyphIconType.home)));

        return navbar;
    }
}
