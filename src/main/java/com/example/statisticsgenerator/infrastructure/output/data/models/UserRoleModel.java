package com.example.statisticsgenerator.infrastructure.output.data.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;
@Data
@Entity
@EqualsAndHashCode(exclude = {"permissions"})
@Table(name = "user_roles", schema = "public")
public class UserRoleModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    @NotBlank
    private String code;

    @ManyToMany
    @JoinTable(
            name = "user_roles_permissions",
            joinColumns = {@JoinColumn(name = "user_role_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_permission_id")}
    )
    private Set<UserPermissionModel> permissions;
}
