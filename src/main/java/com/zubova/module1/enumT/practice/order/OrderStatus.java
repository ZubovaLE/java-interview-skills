package com.zubova.module1.enumT.practice.order;

public enum OrderStatus {
    NEW {
        @Override
        public boolean canTransitionTo(OrderStatus nextStatus) {
            return nextStatus == PROCESSING || nextStatus == CANCELLED;
        }
    },
    PROCESSING {
        @Override
        public boolean canTransitionTo(OrderStatus nextStatus) {
            return nextStatus == SHIPPED || nextStatus == CANCELLED;
        }
    },
    SHIPPED {
        @Override
        public boolean canTransitionTo(OrderStatus nextStatus) {
            return nextStatus == DELIVERED;
        }
    },
    DELIVERED {
        @Override
        public boolean canTransitionTo(OrderStatus nextStatus) {
            return false;
        }
    },
    CANCELLED {
        @Override
        public boolean canTransitionTo(OrderStatus nextStatus) {
            return false;
        }
    };

    /**
     * Проверяет, возможен ли переход в указанный следующий статус.
     * @param nextStatus Целевой статус.
     * @return true, если переход возможен, иначе false.
     */
    public abstract boolean canTransitionTo(OrderStatus nextStatus);

}