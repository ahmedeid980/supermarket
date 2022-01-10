import { HttpHeaders, HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http: HttpClient) { }

  private URL = "http://localhost:7172/supermarket/";

  saveSupermarket(supermarketObj: any, file: any) {
    const headerDict = {
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    let formData = new FormData();
    formData.append('file', file);
    formData.append('supermarketObj', JSON.stringify( supermarketObj ) );

    return this.http.post(this.URL+'saveSupermarket', formData, requestOptions);
  }

  deleteSupermarket(id: number) {
    return this.http.delete(this.URL+'deleteSupermarket/'+id);
  }


  getSupermarketList() {
    return this.http.get(this.URL+'getSupermarketList');
  }

  updateSupermarket(supermarketObj: any, file: any) {
    const headerDict = {
    }

    const requestOptions = {
      headers: new HttpHeaders(headerDict),
    };
    let formData = new FormData();
    formData.append('file', file);
    formData.append('supermarketObj', JSON.stringify( supermarketObj ) );

    return this.http.post(this.URL+'updateSupermarket', formData, requestOptions);
  }
}
