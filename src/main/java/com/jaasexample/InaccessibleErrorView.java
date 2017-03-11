package com.jaasexample;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@CDIView("unauthorized")
public class InaccessibleErrorView extends VerticalLayout implements View {

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        addComponent(new Label("Sorry, view does not exist or you are not authorized to access it"));
    }

}
