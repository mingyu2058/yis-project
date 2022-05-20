package com.service.yis.domain.User;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="usert")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @Column(name="user_name")
    private String userName;

    @Column(name="user_pw")
    private String user_pw;

    @Builder
    public UserEntity(String user_name, String user_pw) {
        this.userName = user_name;
        this.user_pw = user_pw;
    }

    /*
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String userName;

    private String user_password;

    private String mobile_number;

    private String email;

    private int service_agreement;

    private String created_at;

    private String changed_at;

    private int score;

    @Builder
    public UserEntity(String userName, String user_password, String mobile_number, String email, int service_agreement, String created_at, String changed_at, int score) {
        this.userName = userName;
        this.user_password = user_password;
        this.mobile_number = mobile_number;
        this.email = email;
        this.service_agreement = service_agreement;
        this.created_at = created_at;
        this.changed_at = changed_at;
        this.score = score;
    }

 */
}
