package hu.mik.pte.prog4.jaas;

import at.favre.lib.crypto.bcrypt.BCrypt;
import hu.mik.pte.prog4.entity.Role;
import hu.mik.pte.prog4.entity.User;
import hu.mik.pte.prog4.repository.RoleRepository;
import hu.mik.pte.prog4.repository.UserRepository;
import lombok.extern.log4j.Log4j2;

import javax.security.auth.Subject;
import javax.security.auth.callback.*;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Log4j2
public class AuthenticationModule implements LoginModule {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private CallbackHandler handler;
    private Subject subject;
    private String login;
    private List<String> userGroups;

    public AuthenticationModule() {
        this.userRepository = new UserRepository();
        this.roleRepository = new RoleRepository();
    }

    @Override
    public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> sharedState, Map<String, ?> options) {
        this.handler = callbackHandler;
        this.subject = subject;
    }

    @Override
    public boolean login() throws LoginException {
        try {
            Callback[] callbacks = new Callback[2];
            callbacks[0] = new NameCallback("login");
            callbacks[1] = new PasswordCallback("password", true);

            this.handler.handle(callbacks);

            String username = ((NameCallback) callbacks[0]).getName();
            char[] password = ((PasswordCallback) callbacks[1]).getPassword();

            if (username != null && password != null) {
                User user = this.userRepository.findByUsername(username);
                if (user != null && BCrypt.verifyer().verify(password, user.getPassword()).verified) {
                    this.login = username;
                    this.userGroups = this.roleRepository.findRolesByUser(user)
                            .stream()
                            .map(Role::getCode)
                            .collect(Collectors.toList());
                    return true;
                }

            }
            log.error("Authentication failed");
            throw new LoginException("Authentication failed!");
        } catch (IOException | UnsupportedCallbackException e) {
            log.error("Error while trying to log in!", e);
            throw new LoginException(e.getMessage());
        }

    }

    @Override
    public boolean commit() throws LoginException {
        this.subject.getPrincipals().add(new UserPrincipal(this.login));
        this.userGroups.stream().map(RolePrincipal::new).forEach(this.subject.getPrincipals()::add);
        return true;
    }

    @Override
    public boolean abort() throws LoginException {
        return false;
    }

    @Override
    public boolean logout() throws LoginException {
        this.subject.getPrincipals().clear();
        return false;
    }
}
