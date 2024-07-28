package app.vercel.mohammedelyousfi.user_service.presistance.entity;

import app.vercel.mohammedelyousfi.user_service.util.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    public Role(RoleEnum role) {
        this.role = role;
    }
}