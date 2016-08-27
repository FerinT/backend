package com.ferin.domain.client;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

//@Embeddable
@javax.persistence.Entity
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String idNumber;
    private String name;
    private String surname;
    private String membershipType;
    private String email;

    private Client(){}

    private Client(Builder builder) {
        this.id = builder.id;
        this.idNumber = builder.idNumber;
        this.name = builder.name;
        this.surname = builder.surname;
        this.membershipType = builder.membershipType;
        this.email = builder.email;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public Long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public String getEmail() {
        return email;
    }

    public static class Builder {
        private Long id;
        private String idNumber;
        private String name;
        private String surname;
        private String membershipType;
        private String email;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder idNumber(String val) {
            this.idNumber = val;
            return this;
        }

        public Builder name(String val) {
            this.name = val;
            return this;
        }

        public Builder surname(String val) {
            this.surname = val;
            return this;
        }

        public Builder membershipType(String val) {
            this.membershipType = val;
            return this;
        }

        public Builder email(String val) {
            this.email = val;
            return this;
        }

        public Builder copy(Client client) {
            this.id = client.id;
            this.idNumber = client.idNumber;
            this.name = client.name;
            this.surname = client.name;
            this.membershipType = client.membershipType;
            this.email = client.email;

            return this;
        }

        public Client build() {
            return new Client(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (getId() != null ? !getId().equals(client.getId()) : client.getId() != null) return false;
        if (getIdNumber() != null ? !getIdNumber().equals(client.getIdNumber()) : client.getIdNumber() != null)
            return false;
        if (getName() != null ? !getName().equals(client.getName()) : client.getName() != null) return false;
        if (getSurname() != null ? !getSurname().equals(client.getSurname()) : client.getSurname() != null)
            return false;
        if (getMembershipType() != null ? !getMembershipType().equals(client.getMembershipType()) : client.getMembershipType() != null)
            return false;
        return getEmail() != null ? getEmail().equals(client.getEmail()) : client.getEmail() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getIdNumber() != null ? getIdNumber().hashCode() : 0);
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
        result = 31 * result + (getMembershipType() != null ? getMembershipType().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        return result;
    }
}
