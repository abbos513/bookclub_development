package uz.pdp.userregistertest.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterReq {
    @Pattern(regexp = "[0-9.\\\\-_]{12,32}", message = "Phone number must be 12 numbers. Username must be alpha numerical.")
    private String phoneNumber;

//    @NotBlank(message = "Enter email address")
//    @Email(message = "Enter valid email address")
//    private String email;

//    @Size(min = 3, message = "Full name must be minimum 3 characters.")
//    private String fullName;

    @Size(min = 5, max = 16, message = "Password must be between 5 and 16 characters.")
    private String password;

//    private String prePassword;
//
//    @AssertTrue(message="Password is not confirmed.")
//    private boolean isValid() {
//        return this.password.equals(this.prePassword);
//    }

}
