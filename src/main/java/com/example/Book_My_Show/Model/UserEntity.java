package com.example.Book_My_Show.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "mobile_no",unique = true,nullable = false)
    private String mobileNo;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<TicketEntity> ticketEntities;
}
