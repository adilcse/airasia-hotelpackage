import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelPackageService {

  private baseUrl = 'http://airasia-backend/airasia/api/v1/hotelpackages';

  constructor(private http: HttpClient) { }

  getHotelPackage(id: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${id}`);
  }

  createHotelPackage(hotelPackage: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, hotelPackage);
  }

  updateHotelPackage(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${id}`, value);
  }

  deleteHotelPackage(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }

  getHotelPackagesList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
