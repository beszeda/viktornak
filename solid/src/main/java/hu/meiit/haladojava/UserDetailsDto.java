package hu.meiit.haladojava;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
@Builder
@RequiredArgsConstructor

public class UserDetailsDto {
    private final String name;
    private final int age;
    private final int id;
}
