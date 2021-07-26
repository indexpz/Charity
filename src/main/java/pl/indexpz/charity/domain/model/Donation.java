package pl.indexpz.charity.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="donations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;
    @Column(nullable = false)
    @NotNull
    private Integer quantity;
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String zipCode;
    @Column
    private String phone;
    @Column(name="pick_up_date")
    private LocalDate pickUpDate;
    @Column(name="pick_up_time")
    private LocalTime pickUpTime;
    @Column(name="pick_up_comments")
    private String pickUpComment;

    @ManyToMany
    private List<Category> categories = new ArrayList<>();

    @ManyToOne
    private Institution institution;


}
