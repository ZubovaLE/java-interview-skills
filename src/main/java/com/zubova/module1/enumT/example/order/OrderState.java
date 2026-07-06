package com.zubova.module1.enumT.example.order;

public enum OrderState {
    NEW {
        @Override
        public boolean canTransitionTo(OrderState newState) {
            return newState == PROCESSING || newState == CANCELLED;
        }
    },
    PROCESSING {
        @Override
        public boolean canTransitionTo(OrderState newState) {
            return newState == SHIPPED || newState == CANCELLED;
        }
    },
    SHIPPED {
        @Override
        public boolean canTransitionTo(OrderState newState) {
            return newState == DELIVERED;
        }
    },
    DELIVERED {
        @Override
        public boolean canTransitionTo(OrderState newState) {
            return false; // Конечное состояние
        }
    },
    CANCELLED {
        @Override
        public boolean canTransitionTo(OrderState newState) {
            return false; // Конечное состояние
        }
    };

    public abstract boolean canTransitionTo(OrderState newState);

    public void validateTransition(OrderState newState) {
        if (!canTransitionTo(newState)) {
            throw new IllegalStateException(
                "Cannot transition from " + this + " to " + newState
            );
        }
    }
}