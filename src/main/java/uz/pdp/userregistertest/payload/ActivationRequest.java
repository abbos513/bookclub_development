package uz.pdp.userregistertest.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * created by Muhammad
 * on 21.07.2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivationRequest {

    @Size(min = 5,max =5 , message = "Active code must be 5 numbers!")
    private String activeCode;

    @Size(min = 6,max =10 , message = "Active code must be 5 numbers!")
    private String activeCode1;
}
