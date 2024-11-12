package tn.esprit.MicroService.payload.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class LoginRequest {

    @NonNull
    private String username;

    @NonNull
    private String password;

}

