package com.wap.cano_be.domain;

import com.wap.cano_be.domain.enums.Gender;
import com.wap.cano_be.domain.enums.MemberRole;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String name;
    private String socialId;
    private String profileImageUrl;
    @Setter
    private String providerId;
    @Enumerated(EnumType.STRING)
    private MemberRole role;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Setter
    @OneToOne
    @JoinColumn(name="refreshtoken_id", unique = true)
    private RefreshToken refreshToken;
}
