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

package example.upload;

import de.agilecoders.wicket.core.markup.html.bootstrap.form.BootstrapForm;
import de.agilecoders.wicket.extensions.markup.html.bootstrap.form.fileinput.BootstrapFileInput;
import example.BasePage;
import java.util.List;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 *
 * @author dbeer
 */
public class FileUploadPage extends BasePage {

    public FileUploadPage(final PageParameters params) {
        super(params);
        addFileUploafForm();
    }

    private void addFileUploafForm() {
        final IModel<List<FileUpload>> model = new ListModel<FileUpload>();
        BootstrapForm<Void> form = new BootstrapForm<Void>("form");
        form.setOutputMarkupId(true);
        add(form);
        
        BootstrapFileInput bootstrapFileInput = new BootstrapFileInput("bootstrapFileinput", model) {
            @Override
            protected void onSubmit(AjaxRequestTarget target) {
                super.onSubmit(target);

                List<FileUpload> fileUploads = model.getObject();
                if (fileUploads != null) {
                    for (FileUpload upload : fileUploads) {
                        success("Uploaded: " + upload.getClientFileName());
                    }
                }

            }
        };
        form.add(bootstrapFileInput);
    }
    
    
    
}
