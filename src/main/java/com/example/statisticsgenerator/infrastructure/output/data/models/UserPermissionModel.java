package com.example.statisticsgenerator.infrastructure.output.data.models;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(exclude = "roles")
@ToString(exclude = "roles")
@Table(name = "user_permissions", schema = "public")
public class UserPermissionModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    @NotBlank
    private String code;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "permissions")
    private Set<UserRoleModel> roles;
}
