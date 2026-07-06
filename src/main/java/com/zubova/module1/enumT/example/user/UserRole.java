package com.zubova.module1.enumT.example.user;

public enum UserRole {

    ADMIN(new Permissions(true, true, true)),
    MODERATOR(new Permissions(true, true, false)),
    USER(new Permissions(true, false, false));

    private static class Permissions {
        private final boolean canRead;
        private final boolean canWrite;
        private final boolean canDelete;

        Permissions(boolean canRead, boolean canWrite, boolean canDelete) {
            this.canRead = canRead;
            this.canWrite = canWrite;
            this.canDelete = canDelete;
        }
    }

    private final Permissions permissions;

    UserRole(Permissions permissions) {
        this.permissions = permissions;
    }

}