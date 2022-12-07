package entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@Data
public class Product {
    @JsonProperty("id")
    private @NotNull Integer id;
    @JsonProperty("name")
    private @NotNull String name;
    @JsonProperty("companyName")
    private @NotNull String companyName;
    @JsonProperty("amount")
    private @NotNull Integer amount;

    @JsonCreator
    public Product(@JsonProperty(value = "name", required = true) String name,
                   @JsonProperty(value = "companyName", required = true) String  companyName,
                   @JsonProperty(value = "amount", required = true) Integer amount){
        this.name = name;
        this.companyName = companyName;
        this.amount = amount;
    }
}
