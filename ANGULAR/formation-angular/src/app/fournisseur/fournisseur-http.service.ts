import { HttpClient } from '@angular/common/http';
import { Injectable, OnDestroy, OnInit } from '@angular/core';
import { Observable, Subscription } from 'rxjs';
import { GlobalService } from '../global.service';
import { Fournisseur } from '../model';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FournisseurHttpService {

  private fournisseurs: Array<Fournisseur> = new Array<Fournisseur>();
  private fournisseurApiPath: string;

  constructor(private http: HttpClient) {
    this.fournisseurApiPath = environment.apiUrl + "/fournisseur";
    this.load();
  }

  findAll(): Array<Fournisseur> {
    return this.fournisseurs;
  }

  findById(id: number): Observable<Fournisseur> {
    return this.http.get<Fournisseur>(this.fournisseurApiPath + "/" + id);
  }

  create(fournisseur: Fournisseur): void {
    this.http.post<Fournisseur>(this.fournisseurApiPath, fournisseur).subscribe(resp => {
      this.load();
    });
  }

  update(fournisseur: Fournisseur): void {
    this.http.put<Fournisseur>(this.fournisseurApiPath + "/" +  fournisseur.id, fournisseur).subscribe(resp => {
      this.load();
    });
  }

  remove(id: number): void {
    this.http.delete<boolean>(this.fournisseurApiPath + "/" + id).subscribe(resp => {
      this.load();
    });
  }

  private load(): void {
    this.http.get<Array<Fournisseur>>(this.fournisseurApiPath).subscribe(resp => {
        this.fournisseurs = resp;
    })
  }
}
