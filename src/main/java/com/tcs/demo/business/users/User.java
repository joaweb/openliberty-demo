package com.tcs.demo.business.users;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author joaquinmartinezgutierrez
 */
@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @SequenceGenerator(name="users_id_seq", sequenceName="users_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="users_id_seq")
    private int id;
    private String bankName;
    private String accountHolderName;
    private String accountNumber;
    private String accountHolderEmail;
}
