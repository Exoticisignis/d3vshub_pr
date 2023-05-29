package com.example.infrastructure.models;

import com.example.infrastructure.entities.Customer;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

/**
 * Customer
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public class CustomerDTO   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("address")
  private String address;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("login")
  private String login;

  @JsonProperty("salt")
  private String salt;

  @JsonProperty("password")
  private String password;

  public CustomerDTO(){

  }

  public CustomerDTO(Customer customer){
    this.id = customer.getCustomerId();
    this.name = customer.getName();
    this.surname = customer.getSurname();
    this.phone = customer.getPhone();
    this.login = customer.getEmail();
  }

  public CustomerDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public CustomerDTO name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CustomerDTO surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public CustomerDTO address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public CustomerDTO phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public CustomerDTO login(String login) {
    this.login = login;
    return this;
  }

  /**
   * Get login
   * @return login
  */
  @ApiModelProperty(value = "")


  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public CustomerDTO salt(String salt) {
    this.salt = salt;
    return this;
  }

  /**
   * Get salt
   * @return salt
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getSalt() {
    return salt;
  }

  public void setSalt(String salt) {
    this.salt = salt;
  }

  public CustomerDTO password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerDTO customer = (CustomerDTO) o;
    return Objects.equals(this.id, customer.id) &&
        Objects.equals(this.name, customer.name) &&
        Objects.equals(this.surname, customer.surname) &&
        Objects.equals(this.address, customer.address) &&
        Objects.equals(this.phone, customer.phone) &&
        Objects.equals(this.login, customer.login) &&
        Objects.equals(this.salt, customer.salt) &&
        Objects.equals(this.password, customer.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, surname, address, phone, login, salt, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Customer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("    login: ").append(toIndentedString(login)).append("\n");
    sb.append("    salt: ").append(toIndentedString(salt)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

