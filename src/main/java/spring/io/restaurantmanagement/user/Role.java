package spring.io.restaurantmanagement.user;

public enum Role {
    ROLE_ADMIN,
    ROLE_USER,
    ROLE_COOK,
    ROLE_WAITER;

    public static Role[] getRoles() {
        return Role.class.getEnumConstants();
    }
}
