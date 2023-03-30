import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Fournisseur } from '../model';

@Injectable({
  providedIn: 'root'
})
export class FournisseurHttpService {

  private fournisseurs: Array<Fournisseur> = new Array<Fournisseur>();


  constructor(private http: HttpClient) {
    this.load();
  }

  findAll(): Array<Fournisseur> {
    return this.fournisseurs;
  }

  findById(id: number): Fournisseur {
    return null;
  }

  create(fournisseur: Fournisseur): void {
    this.http.post<Fournisseur>("http://localhost:8080/api/fournisseur", fournisseur).subscribe(resp => {
      this.load();
    });
  }

  update(fournisseur: Fournisseur): void {
    
  }

  remove(id: number): void {
    
  }

  private load(): void {
    this.http.get<Array<Fournisseur>>("http://localhost:8080/api/fournisseur").subscribe(resp => {
        this.fournisseurs = resp;
    })
  }
}
