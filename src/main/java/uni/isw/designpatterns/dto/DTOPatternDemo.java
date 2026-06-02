package uni.isw.designpatterns.dto;

public class DTOPatternDemo {
    public static void main(String[] args) {
        // Simulating a user retrieved from a database (Domain Entity)
        User user = new User(1, "John Doe", "john.doe@example.com", "secret_password_123");
        
        System.out.println("--- Domain Entity (Internal Model) ---");
        System.out.println("ID: " + user.getId());
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Password: " + user.getPassword()); // Sensitive data exposed internally
        
        // Converting Entity to DTO using the Mapper
        UserDTO userDTO = UserMapper.toDTO(user);
        
        System.out.println("\n--- Data Transfer Object (DTO) ---");
        System.out.println(userDTO);
        // Notice that the password is not present in the DTO
        
        // Demonstrating the reverse mapping (if needed for updates)
        User mappedUser = UserMapper.toEntity(userDTO);
        System.out.println("\n--- Entity mapped back from DTO ---");
        System.out.println("ID: " + mappedUser.getId());
        System.out.println("Name: " + mappedUser.getName());
        System.out.println("Email: " + mappedUser.getEmail());
        System.out.println("Password: " + mappedUser.getPassword()); // Password will be null
    }
}
