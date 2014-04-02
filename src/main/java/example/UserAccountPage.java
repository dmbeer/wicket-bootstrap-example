/*
 * Copyright 2014 dbeer.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example;

import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapAjaxLink;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import java.util.ArrayList;
import java.util.List;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dbeer
 */
public class UserAccountPage extends BasePage {

    UserProfilePanel userProfilePanel;
    ChangePasswordPanel changePasswordPanel;

    public UserAccountPage(final PageParameters parameters) {
        super(parameters);

        addPanels();
        addLink();
        add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

    }

    private void addPanels() {
        userProfilePanel =  new UserProfilePanel("user-profile");
        changePasswordPanel = new ChangePasswordPanel("change-password");
        add(userProfilePanel);
        add(changePasswordPanel);
    }
    private void addLink() {
        BootstrapAjaxLink link = new BootstrapAjaxLink("link-dsiable-password", Model.of("Disable Password Change"), Buttons.Type.Link) {

            @Override
            public void onClick(AjaxRequestTarget target) {
                target.add(changePasswordPanel.form);
                target.add(this);
                if (changePasswordPanel.form.isVisible()) {
                    this.setLabel(Model.of("Enable Password Panel"));
                    changePasswordPanel.form.setVisible(false);
                } else {
                    this.setLabel(Model.of("Disable Password Change"));
                    changePasswordPanel.form.setVisible(true);
                }
                
            }
        };
        add(link);
    }

}
