package idusw.javaweb.sba2.domain;

import java.sql.Timestamp;
import java.util.Objects;

public class Member {
    private long id;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String role;
    private Timestamp regDateTime;

    public long getId() {        return id;    }
    public void setId(long id) {        this.id = id;    }
    public String getEmail() {        return email;    }
    public void setEmail(String email) {        this.email = email;    }
    public String getPassword() {        return password;    }
    public void setPassword(String password) {        this.password = password;    }
    public String getPhone() {        return phone;    }
    public void setPhone(String phone) {        this.phone = phone;    }
    public String getAddress() {        return address;    }
    public void setAddress(String address) {        this.address = address;    }
    public String getRole() {        return role;    }
    public void setRole(String role) {        this.role = role;    }
    public Timestamp getRegDateTime() {        return regDateTime;    }
    public void setRegDateTime(Timestamp regDateTime) {        this.regDateTime = regDateTime;    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id && Objects.equals(email, member.email)
                && Objects.equals(password, member.password) &&
                Objects.equals(phone, member.phone) && Objects.equals(address, member.address)
                && Objects.equals(role, member.role) && Objects.equals(regDateTime, member.regDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, phone, address, role, regDateTime);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", regDateTime=" + regDateTime +
                '}';
    }
}
