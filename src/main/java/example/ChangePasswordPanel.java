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
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

/**
 *
 * @author dbeer
 */
public class ChangePasswordPanel extends Panel {
    
    Form<Void> form;

    public ChangePasswordPanel() {
        super("panel");
        add(addChangePassword());
    }
    
    public ChangePasswordPanel(String id) {
        super(id);
        add(addChangePassword());
    }
    
    private Form<Void> addChangePassword() {
        final PasswordTextField password = new PasswordTextField("password");
        final PasswordTextField confirmPassword = new PasswordTextField("confirmPassword");
        form = new BootstrapForm<Void>("form");
        form.add(new FormBehavior().type(FormType.Horizontal));
        form.setOutputMarkupId(true);
        form.setOutputMarkupPlaceholderTag(true);
        
        FormGroup formGroupPassword =  new FormGroup("formGroupPassword", Model.of("Password"));
        formGroupPassword.add(password);
        form.add(formGroupPassword);
        
        FormGroup formGroupConfirmPassword =  new FormGroup("formGroupConfirmPassword", Model.of("Confirm Password"));
        formGroupConfirmPassword.add(confirmPassword);
        form.add(formGroupConfirmPassword);
        
        
        FormGroup formGrouButton = new FormGroup("formGroupButton");
        BootstrapButton submitButton = new BootstrapButton("submit-button", Buttons.Type.Default);
        submitButton.setLabel(Model.of("Submit"));
        formGrouButton.add(submitButton);
        form.add(formGrouButton);
        
        return form;
    }
    
}
