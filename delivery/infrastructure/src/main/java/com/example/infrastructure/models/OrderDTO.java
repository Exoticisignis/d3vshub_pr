package com.example.infrastructure.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Order
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-05-16T17:35:02.597539500+02:00[Europe/Warsaw]")
public class OrderDTO   {
  @JsonProperty("id")
  private Long id;

  @JsonProperty("customer")
  private Long customer;

  @JsonProperty("orderItems")
  @Valid
  private List<String> orderItems = new ArrayList<>();

  @JsonProperty("orderDate")
  private String orderDate;

  @JsonProperty("totalPrice")
  private Double totalPrice;

  @JsonProperty("address")
  private String address;

  public OrderDTO id(Long id) {
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

  public OrderDTO customer(Long customer) {
    this.customer = customer;
    return this;
  }

  /**
   * Get customer
   * @return customer
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Long getCustomer() {
    return customer;
  }

  public void setCustomer(Long customer) {
    this.customer = customer;
  }

  public OrderDTO orderItems(List<String> orderItems) {
    this.orderItems = orderItems;
    return this;
  }

  public OrderDTO addOrderItemsItem(String orderItemsItem) {
    this.orderItems.add(orderItemsItem);
    return this;
  }

  /**
   * Get orderItems
   * @return orderItems
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<String> getOrderItems() {
    return orderItems;
  }

  public void setOrderItems(List<String> orderItems) {
    this.orderItems = orderItems;
  }

  public OrderDTO orderDate(String orderDate) {
    this.orderDate = orderDate;
    return this;
  }

  /**
   * Get orderDate
   * @return orderDate
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }

  public OrderDTO totalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
    return this;
  }

  /**
   * Get totalPrice
   * @return totalPrice
  */
  @ApiModelProperty(required = true, value = "")
  @NotNull


  public Double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Double totalPrice) {
    this.totalPrice = totalPrice;
  }

  public OrderDTO address(String address) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDTO order = (OrderDTO) o;
    return Objects.equals(this.id, order.id) &&
        Objects.equals(this.customer, order.customer) &&
        Objects.equals(this.orderItems, order.orderItems) &&
        Objects.equals(this.orderDate, order.orderDate) &&
        Objects.equals(this.totalPrice, order.totalPrice) &&
        Objects.equals(this.address, order.address);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, customer, orderItems, orderDate, totalPrice, address);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    customer: ").append(toIndentedString(customer)).append("\n");
    sb.append("    orderItems: ").append(toIndentedString(orderItems)).append("\n");
    sb.append("    orderDate: ").append(toIndentedString(orderDate)).append("\n");
    sb.append("    totalPrice: ").append(toIndentedString(totalPrice)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
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

