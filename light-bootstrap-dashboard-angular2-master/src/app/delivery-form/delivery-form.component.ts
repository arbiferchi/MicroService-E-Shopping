import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DeliveryService } from '../delivery.service';
import { Delivery, DeliveryStatus } from '../delivery.model';

@Component({
    selector: 'app-delivery-form',
    templateUrl: './delivery-form.component.html',
    styleUrls: ['./delivery-form.component.scss']
})
export class DeliveryFormComponent implements OnInit {
    deliveryForm: FormGroup;
    isEditMode = false;
    deliveryId?: number;
    deliveryStatuses = Object.values(DeliveryStatus);

    constructor(
        private fb: FormBuilder,
        private deliveryService: DeliveryService,
        private router: Router,
        private route: ActivatedRoute
    ) {
        this.deliveryForm = this.fb.group({
            orderNumber: ['', [Validators.required, Validators.minLength(3)]],
            customerName: ['', [Validators.required, Validators.minLength(3)]],
            deliveryAddress: ['', [Validators.required, Validators.minLength(5)]],
            phoneNumber: ['', [Validators.required, Validators.pattern('^[0-9]{8,}$')]],
            status: [DeliveryStatus.PENDING],
            totalAmount: ['', [Validators.required, Validators.min(0)]],
            estimatedDeliveryTime: ['', Validators.required]
        });
    }

    ngOnInit(): void {
        this.deliveryId = Number(this.route.snapshot.paramMap.get('id'));
        if (this.deliveryId) {
            this.isEditMode = true;
            this.loadDelivery();
        }
    }

    loadDelivery(): void {
        this.deliveryService.getDeliveryById(this.deliveryId!).subscribe({
            next: (delivery) => {
                this.deliveryForm.patchValue({
                    orderNumber: delivery.orderNumber,
                    customerName: delivery.customerName,
                    deliveryAddress: delivery.deliveryAddress,
                    phoneNumber: delivery.phoneNumber,
                    status: delivery.status,
                    totalAmount: delivery.totalAmount,
                    estimatedDeliveryTime: new Date(delivery.estimatedDeliveryTime)
                        .toISOString().substring(0, 16)
                });
            },
            error: (error) => console.error('Error loading delivery:', error)
        });
    }

    onSubmit(): void {
      if (this.deliveryForm.valid) {
          const delivery: Delivery = {
              ...this.deliveryForm.value,
              id: this.isEditMode ? this.deliveryId : undefined
          };

          const operation = this.isEditMode
              ? this.deliveryService.updateDeliveryStatus(this.deliveryId!, delivery.status)
              : this.deliveryService.createDelivery(delivery);

          operation.subscribe({
              next: () => {
                  this.router.navigate(['/list-delivery']);
              },
              error: (error) => console.error('Error saving delivery:', error)
          });
      }
    }

    // Helper method to check form field validity
    isFieldInvalid(fieldName: string): boolean {
        const field = this.deliveryForm.get(fieldName);
        return field ? field.invalid && (field.dirty || field.touched) : false;
    }

   
}