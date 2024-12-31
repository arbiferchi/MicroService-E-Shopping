import { Component, OnInit } from '@angular/core';
import { DeliveryService } from '../delivery.service';
import { Delivery, DeliveryStatus } from '../delivery.model';

@Component({
    selector: 'app-delivery-list',
    templateUrl: './delivery-list.component.html',
    styleUrls: ['./delivery-list.component.scss']
})
export class DeliveryListComponent implements OnInit {
    deliveries: Delivery[] = [];
    filteredDeliveries: Delivery[] = [];
    statusFilter: string = '';
    customerNameFilter: string = '';
    deliveryStatuses = Object.values(DeliveryStatus);

    constructor(private deliveryService: DeliveryService) { }

    ngOnInit(): void {
        this.loadDeliveries();
    }

    loadDeliveries(): void {
        this.deliveryService.getAllDeliveries().subscribe({
            next: (data) => {
                this.deliveries = data;
                this.applyFilters();
            },
            error: (error) => console.error('Error loading deliveries:', error)
        });
    }

    applyFilters(): void {
        this.filteredDeliveries = this.deliveries.filter(delivery => {
            const matchesStatus = !this.statusFilter || delivery.status === this.statusFilter;
            const matchesCustomer = !this.customerNameFilter || 
                delivery.customerName.toLowerCase().includes(this.customerNameFilter.toLowerCase());
            return matchesStatus && matchesCustomer;
        });
    }

    updateStatus(delivery: Delivery, newStatus: string): void {
        this.deliveryService.updateDeliveryStatus(delivery.id!, newStatus).subscribe({
            next: (updatedDelivery) => {
                const index = this.deliveries.findIndex(d => d.id === updatedDelivery.id);
                if (index !== -1) {
                    this.deliveries[index] = updatedDelivery;
                    this.applyFilters();
                }
            },
            error: (error) => console.error('Error updating status:', error)
        });
    }

    deleteDelivery(id: number): void {
        if (confirm('Are you sure you want to delete this delivery?')) {
            this.deliveryService.deleteDelivery(id).subscribe({
                next: () => {
                    this.deliveries = this.deliveries.filter(d => d.id !== id);
                    this.applyFilters();
                },
                error: (error) => console.error('Error deleting delivery:', error)
            });
        }
    }
}