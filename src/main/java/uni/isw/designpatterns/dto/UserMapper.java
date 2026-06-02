package uni.isw.designpatterns.dto;

public class UserMapper {
    
    public static UserDTO toDTO(User user) {
        if (user == null) {
            return null;
        }
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public static User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        // Password is set to null as it is not part of the DTO
        return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), null);
    }
}
