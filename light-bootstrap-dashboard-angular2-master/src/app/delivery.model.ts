export interface Delivery {
    id?: number;
    orderNumber: string;
    customerName: string;
    deliveryAddress: string;
    phoneNumber: string;
    status: DeliveryStatus;
    totalAmount: number;
    estimatedDeliveryTime: Date;
    createdAt?: Date;
    updatedAt?: Date;
}

export enum DeliveryStatus {
    PENDING = 'PENDING',
    IN_TRANSIT = 'IN_TRANSIT',
    DELIVERED = 'DELIVERED',
    CANCELLED = 'CANCELLED'
}

// Optional: Interface for creating a new delivery (without readonly fields)
export interface CreateDeliveryDto {
    orderNumber: string;
    customerName: string;
    deliveryAddress: string;
    phoneNumber: string;
    totalAmount: number;
    estimatedDeliveryTime: Date;
}