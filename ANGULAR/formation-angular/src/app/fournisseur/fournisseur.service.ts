import { Injectable } from '@angular/core';
import { Fournisseur } from '../model';
import { FournisseurComponent } from './fournisseur.component';

@Injectable({
  providedIn: 'root'
})
export class FournisseurService {

  private fournisseurs: Array<Fournisseur> = new Array<Fournisseur>();

  constructor() { 
    this.fournisseurs.push(new Fournisseur(4, "LEROY MERLIN"));
    this.fournisseurs.push(new Fournisseur(6, "CASTORAMA"));
  }

  findAll(): Array<Fournisseur> {
    return this.fournisseurs;
  }

  findById(id: number): Fournisseur {
    return this.fournisseurs.find(f => f.id == id);
  }

  create(fournisseur: Fournisseur): void {
    let maxId = 0;

    this.fournisseurs.forEach(f => {
      if(f.id > maxId) {
        maxId = f.id;
      }
    });

    fournisseur.id = maxId + 1;  

    this.fournisseurs.push(fournisseur);
  }

  update(fournisseur: Fournisseur): void {
    let idx: number;

    idx = this.fournisseurs.findIndex(f => f.id == fournisseur.id);

    this.fournisseurs[idx] = fournisseur;
  }

  remove(id: number): void {
    let idx: number = this.fournisseurs.findIndex(f => f.id == id);

    this.fournisseurs.splice(idx, 1);
  }
}
