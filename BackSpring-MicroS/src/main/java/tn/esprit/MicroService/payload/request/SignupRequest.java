package tn.esprit.MicroService.payload.request;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SignupRequest {
    @NonNull
    private String username;

    @NonNull
    private String email;

    private Set<String> role;

    @NonNull
    private String password;

    @NonNull
    private String tel;

    @NonNull
    private String image;

}