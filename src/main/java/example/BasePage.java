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
import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.MetaTag;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.MobileViewportMetaTag;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeCDNCSSReference;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.icon.FontAwesomeCssReference;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Created by dbeer on 12/12/13.
 */
public class BasePage<T> extends GenericWebPage<T> {

    public BasePage() {
        super();
    }

    public BasePage(final PageParameters params) {
        super(params);

        add(new HtmlTag("html"));

        add(new MobileViewportMetaTag("viewport"));
        add(new MetaTag("description", Model.of("description"), Model.of("Test")));
        add(new MetaTag("author", Model.of("author"), Model.of("Hello")));

        //add header panel
        add(new HeaderPanel("header"));
        add(new FooterPanel("footer"));
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);

        Bootstrap.renderHead(response);
        response.render(CssHeaderItem.forReference(FontAwesomeCDNCSSReference.instance()));
    }

}
