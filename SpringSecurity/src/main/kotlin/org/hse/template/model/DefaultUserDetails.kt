package org.hse.template.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.UUID

@Table("default_user")
class DefaultUserDetails(
    @Id
    var id: UUID? = null,
    private var name: String,
    private var password: String,
    private var role: AuthorityType
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf(role)

    fun setName(name: String) {
        this.name = name
    }

    override fun getUsername() = name

    fun setPassword(password: String) {
        this.password = password
    }

    override fun getPassword() = password

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true

    enum class AuthorityType : GrantedAuthority {
        ADMIN,
        DEFAULT;

        override fun getAuthority() = this.name
    }
}