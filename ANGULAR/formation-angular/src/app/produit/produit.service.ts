import { Injectable } from '@angular/core';
import { Produit } from '../model';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  private produits: Array<Produit> = new Array<Produit>();

  constructor() { 
    this.produits.push(new Produit(3, "Perceuse Visseuse BOSCH", 325.50));
    this.produits.push(new Produit(4, "Equerre à bois", 15));
    this.produits.push(new Produit(14, "Echelle", 150));
  }

  findAll(): Array<Produit> {
    return this.produits;
  }

  findById(id: number): Produit {
    return this.produits.find(f => f.id == id);
  }

  create(produit: Produit): void {
    let maxId = 0;

    this.produits.forEach(f => {
      if(f.id > maxId) {
        maxId = f.id;
      }
    });

    produit.id = maxId + 1;  

    this.produits.push(produit);
  }

  update(produit: Produit): void {
    let idx: number;

    idx = this.produits.findIndex(f => f.id == produit.id);

    this.produits[idx] = produit;
  }

  remove(id: number): void {
    let idx: number = this.produits.findIndex(f => f.id == id);

    this.produits.splice(idx, 1);
  }
}
