import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GlobalService } from '../global.service';
import { Produit, ProduitRequestResponse } from '../model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ProduitHttpService {

  produits : Array<Produit> = new Array<Produit>();

  private produitApiPath: string;

  constructor(private http: HttpClient) {
    this.produitApiPath = environment.apiUrl + "/produit";
    this.load();
  }

  findAll(): Array<Produit> {
    return this.produits;
  }

  findById(id: number): Observable<ProduitRequestResponse> {
    return this.http.get<ProduitRequestResponse>(this.produitApiPath + "/" + id);
  }

  create(produit: ProduitRequestResponse): void {
    this.http.post<Produit>(this.produitApiPath, produit).subscribe(resp => {
      this.load();
   })
;  }

  update(produit: ProduitRequestResponse): void {
    this.http.put<Produit>(this.produitApiPath + "/" +  produit.id, produit).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<boolean>(this.produitApiPath + "/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Produit>>(this.produitApiPath).subscribe(resp => {
        this.produits = resp;
    })
  }

}
