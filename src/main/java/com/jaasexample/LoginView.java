package com.jaasexample;

import com.vaadin.cdi.CDIView;
import com.vaadin.cdi.access.JaasAccessControl;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.Notification;

import javax.servlet.ServletException;
import java.util.logging.Logger;

import static com.vaadin.ui.Notification.Type.ERROR_MESSAGE;

@CDIView("login")
public class LoginView extends LoginForm implements View {

    public static final String VIEW_NAME = "login";
    private static final Logger logger = Logger.getLogger(LoginView.class.getCanonicalName());

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        final String parameters = viewChangeEvent.getParameters();
        addLoginListener(loginEvent -> onLogin(loginEvent, parameters));
    }

    private void onLogin(LoginEvent loginEvent, final String parameters) {
        final String username = loginEvent.getLoginParameter("username");
        final String password = loginEvent.getLoginParameter("password");

        try {
            JaasAccessControl.login(username, password);
            Notification.show("Login successful");
            final String nextView = parameters != null ? parameters : SecureView.VIEW_NAME;
            getUI().getNavigator().navigateTo(nextView);

        } catch (ServletException e) {
            Notification.show("Login failed", ERROR_MESSAGE);
            logger.warning(e.toString());
        }
    }

}
