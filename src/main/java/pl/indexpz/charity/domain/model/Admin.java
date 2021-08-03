package pl.indexpz.charity.domain.model;

import javax.persistence.*;

@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String adminname;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String role;
}
