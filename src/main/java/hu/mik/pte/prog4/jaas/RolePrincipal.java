package hu.mik.pte.prog4.jaas;

import lombok.Data;

import java.io.Serializable;
import java.security.Principal;

@Data
public class RolePrincipal implements Principal, Serializable {
    private final String name;
}
