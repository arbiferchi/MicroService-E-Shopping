import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Delivery } from './delivery.model';
import { environment } from '../environments/environment';  // import environment

@Injectable({
    providedIn: 'root'
})
export class DeliveryService {
    private apiUrl = environment.apiUrl;  // use environment API URL

    constructor(private http: HttpClient) { }

    createDelivery(delivery: Delivery): Observable<Delivery> {
        return this.http.post<Delivery>(`${this.apiUrl}/create`, delivery);
    }

    getAllDeliveries(): Observable<Delivery[]> {
        return this.http.get<Delivery[]>(`${this.apiUrl}/list`);
    }

    getDeliveryById(id: number): Observable<Delivery> {
        return this.http.get<Delivery>(`${this.apiUrl}/${id}`);
    }

    getDeliveriesByStatus(status: string): Observable<Delivery[]> {
        return this.http.get<Delivery[]>(`${this.apiUrl}/status/${status}`);
    }

    getDeliveriesByCustomer(customerName: string): Observable<Delivery[]> {
        return this.http.get<Delivery[]>(`${this.apiUrl}/customer/${customerName}`);
    }

    updateDeliveryStatus(id: number, status: string): Observable<Delivery> {
        return this.http.put<Delivery>(`${this.apiUrl}/${id}/status`, null, {
            params: new HttpParams().set('status', status)
        });
    }

    updateEstimatedDeliveryTime(id: number, estimatedTime: Date): Observable<Delivery> {
        return this.http.put<Delivery>(`${this.apiUrl}/${id}/estimated-time`, null, {
            params: new HttpParams().set('estimatedTime', estimatedTime.toISOString())
        });
    }

    deleteDelivery(id: number): Observable<void> {
        return this.http.delete<void>(`${this.apiUrl}/${id}`);
    }

    getDeliveriesByDateRange(startDate: Date, endDate: Date): Observable<Delivery[]> {
        const params = new HttpParams()
            .set('startDate', startDate.toISOString())
            .set('endDate', endDate.toISOString());
        return this.http.get<Delivery[]>(`${this.apiUrl}/date-range`, { params });
    }
}