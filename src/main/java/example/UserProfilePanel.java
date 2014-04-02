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

import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapButton;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapForm;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormGroup;
import de.agilecoders.wicket.core.markup.html.bootstrap.form.FormType;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 *
 * @author dbeer
 */
public class UserProfilePanel extends Panel {

    public UserProfilePanel() {
        super("panel");
        add(UserProfile());
    }

    public UserProfilePanel(String id) {
        super(id);
        add(UserProfile());
    }

    private Form<Void> UserProfile() {
        final TextField name = new TextField("name", Model.of("Joe Blogs"));
        final EmailTextField email = new EmailTextField("email", Model.of("joe@example.com"));
        Form<Void> form = new BootstrapForm<Void>("form");
        form.add(new FormBehavior().type(FormType.Horizontal));
        
        FormGroup formGroupInfo =  new FormGroup("formGroupInfo", Model.of("Name"));
        formGroupInfo.add(name);
        formGroupInfo.add(email);
        form.add(formGroupInfo);
        
        FormGroup formGroupEmail =  new FormGroup("formGroupEmail", Model.of("Email Address"));
        formGroupEmail.add(email);
        form.add(formGroupEmail);
        
        FormGroup formGrouButton = new FormGroup("formGroupButton");
        BootstrapButton submitButton = new BootstrapButton("submit-button", Buttons.Type.Default);
        submitButton.setLabel(Model.of("Submit"));
        formGrouButton.add(submitButton);
        form.add(formGrouButton);
        
        return form;
    }
    
}
