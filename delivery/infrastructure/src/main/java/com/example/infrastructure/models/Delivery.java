package com.example.infrastructure.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import jakarta.validation.constraints.NotNull;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * Delivery
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public class Delivery   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("order")
  private Long order;

  @JsonProperty("courier")
  private Long courier;

  @JsonProperty("deliveryDate")
  @org.springframework.format.annotation.DateTimeFormat(iso = org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime deliveryDate;

  public Delivery id(Long id) {
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

  public Delivery order(Long order) {
    this.order = order;
    return this;
  }

  /**
   * Get order
   * @return order
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getOrder() {
    return order;
  }

  public void setOrder(Long order) {
    this.order = order;
  }

  public Delivery courier(Long courier) {
    this.courier = courier;
    return this;
  }

  /**
   * Get courier
   * @return courier
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getCourier() {
    return courier;
  }

  public void setCourier(Long courier) {
    this.courier = courier;
  }

  public Delivery deliveryDate(OffsetDateTime deliveryDate) {
    this.deliveryDate = deliveryDate;
    return this;
  }

  /**
   * Get deliveryDate
   * @return deliveryDate
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public OffsetDateTime getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(OffsetDateTime deliveryDate) {
    this.deliveryDate = deliveryDate;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Delivery delivery = (Delivery) o;
    return Objects.equals(this.id, delivery.id) &&
        Objects.equals(this.order, delivery.order) &&
        Objects.equals(this.courier, delivery.courier) &&
        Objects.equals(this.deliveryDate, delivery.deliveryDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, order, courier, deliveryDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Delivery {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
    sb.append("    courier: ").append(toIndentedString(courier)).append("\n");
    sb.append("    deliveryDate: ").append(toIndentedString(deliveryDate)).append("\n");
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

