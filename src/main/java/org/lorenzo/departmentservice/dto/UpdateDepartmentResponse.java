package org.lorenzo.departmentservice.dto;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.lorenzo.departmentservice.model.Department;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UpdateDepartmentResponse
 */

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2024-07-12T09:15:38.806823050Z[GMT]")


public class UpdateDepartmentResponse   {
  @JsonProperty("department")
  private Department department = null;

  public UpdateDepartmentResponse department(Department department) {
    this.department = department;
    return this;
  }

  /**
   * Get department
   * @return department
   **/
  @Schema(description = "")
      @NotNull

    @Valid
    public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateDepartmentResponse updateDepartmentResponse = (UpdateDepartmentResponse) o;
    return Objects.equals(this.department, updateDepartmentResponse.department);
  }

  @Override
  public int hashCode() {
    return Objects.hash(department);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateDepartmentResponse {\n");
    
    sb.append("    department: ").append(toIndentedString(department)).append("\n");
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
