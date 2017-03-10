package com.jaasexample;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@CDIView(SecureView.VIEW_NAME)
// @RolesAllowed("users")
public class SecureView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "secure";

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> addComponent(new Label("Thanks " + name.getValue() + ", it works!")));

        addComponents(name, button);
    }

}
